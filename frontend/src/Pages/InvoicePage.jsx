import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { jsPDF } from "jspdf";
import logo from "../Content/logo3.png";

const InvoicePage = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const { username ,segment, model, manufacturer, selectedParts = {}, basePrice = 0, totalprice = 0, tax = 0, ftp = 0, quantity = 1 } = location.state || {};

  const [transactionId, setTransactionId] = useState(null); // State to store transaction ID

  useEffect(() => {

    const token = sessionStorage.getItem("authToken");
    if (!token) {
      navigate("/LoginPage");
    }
  }, [navigate]);

  console.log("++++++++++++++>>>",{
    model,
    manufacturer,
    selectedParts,
    basePrice,
    totalprice,
    tax,
    ftp,
    quantity,
    username,
    segment
  });
  const invoiceData = {
      InvoiceNumber : transactionId,
    modelName: model.name,
    username: username,
    components: Object.values(selectedParts).map(part => part.comp_name),
    basePrice: basePrice,
    tax: tax,
    totalPrice: totalprice,
    finalTotalPrice: ftp,
    quantity: quantity,
    segment: segment.name,
    manufacturer : manufacturer.name
};

console.log("invice data for pratik",invoiceData);

  const orderDate = new Date().toLocaleDateString("en-GB", {
    day: "numeric",
    month: "long",
    year: "numeric",
  }


);

  const generatePDF = () => {
    const doc = new jsPDF();
    let marginLeft = 20;
    let yOffset = 20;
    let pageWidth = 190; // Max width for text placement
  
    // Add company name and invoice title
    doc.setFontSize(22);
    doc.setTextColor(40, 40, 40);
    doc.text("Vconfig", marginLeft, yOffset);
    
    doc.setFontSize(14);
    doc.setTextColor(100, 100, 100);
    doc.text("Invoice", 150, yOffset);
  
    // Order Date & Transaction ID
    yOffset += 10;
    doc.setFontSize(10);
    doc.text(`Order Date: ${orderDate}`, 150, yOffset);
  
    // Wrap long Transaction ID properly
    let transactionText = `Transaction ID: ${transactionId || "N/A"}`;
    let transactionLines = doc.splitTextToSize(transactionText, 40); // Wrap if > 40px width
    yOffset += 10;
    doc.text(transactionLines, 150, yOffset);
  
    // Adjust yOffset dynamically based on text height
    yOffset += transactionLines.length * 5;
  
    // Horizontal line
    yOffset += 10;
    doc.setDrawColor(150);
    doc.line(marginLeft, yOffset, pageWidth, yOffset);
  
    // Order Details
    yOffset += 10;
    doc.setFontSize(12);
    doc.text("Order Details", marginLeft, yOffset);
    
    doc.setFontSize(10);
    yOffset += 10;
    doc.text(`Manufacturer: ${manufacturer?.name || "N/A"}`, marginLeft, yOffset);
    doc.text(`Model: ${model?.name || "N/A"}`, marginLeft, yOffset + 10);
    doc.text(`Quantity: ${quantity || "N/A"}`, marginLeft, yOffset + 20);
  
    // Pricing Details in Table Format
    yOffset += 40;
    doc.setFontSize(12);
    doc.text("Pricing Details", marginLeft, yOffset);
    yOffset += 10;
  
    const pricingData = [
      ["Base Price", `₹${basePrice?.toLocaleString() || "N/A"}`],
      ["Tax (18%)", `₹${tax?.toLocaleString() || "N/A"}`],
      ["Total Price", `₹${totalprice?.toLocaleString() || "N/A"}`],
      ["Final Total Price", `₹${ftp?.toLocaleString() || "N/A"}`],
    ];
  
    pricingData.forEach(([label, value]) => {
      doc.text(label, marginLeft, yOffset);
      doc.text(value, 150, yOffset);
      yOffset += 10;
    });
  
    // Horizontal Line before parts
    yOffset += 10;
    doc.line(marginLeft, yOffset, pageWidth, yOffset);
  
    // Selected Parts Section
    yOffset += 10;
    doc.setFontSize(12);
    doc.text("Selected Parts", marginLeft, yOffset);
    yOffset += 10;
  
    // Table for Selected Parts
    doc.setFontSize(10);
    doc.setFillColor(230, 230, 230);
    doc.rect(marginLeft, yOffset, 170, 10, "F");
    doc.setTextColor(0);
    doc.text("Component Name", marginLeft + 5, yOffset + 7);
    yOffset += 15;
  
    Object.values(selectedParts || {}).forEach((part) => {
      if (yOffset > 270) { // Prevent overflow
        doc.addPage();
        yOffset = 20;
      }
      doc.text(`- ${part?.comp_name || "N/A"}`, marginLeft + 5, yOffset);
      yOffset += 10;
    });
  
    // Save the PDF
    doc.save(`Invoice_${model?.name || "Unknown"}.pdf`);
  };
  
  

  const displayRazorpay = async () => {

    const loadScript = (src) => {
      return new Promise((resolve) => {
        const script = document.createElement("script");
        script.src = src;
        script.onload = () => resolve(true);
        script.onerror = () => resolve(false);
        document.body.appendChild(script);
      });
    };

    const res = await loadScript("https://checkout.razorpay.com/v1/checkout.js");
    if (!res) {
      alert("You are offline... Failed to load Razorpay SDK");
      return;
    }

    const options = {
      key: "rzp_test_k5f8UaRhMZ6s1L",
      currency: "INR",
      amount: 100 * 100, // Convert to paise (Razorpay expects amount in the smallest currency unit)
      name: "Vconfig",
      description: "Thanks for your order...",
      image: logo,
      handler: function (response) {
        // Store the transaction ID in state
        setTransactionId(response.razorpay_payment_id);
        alert(`Payment Successful! Transaction ID: ${response.razorpay_payment_id}`);
      },
      prefill: {
        name: "Vconfig",
      },
    };

    const paymentObject = new window.Razorpay(options);
    paymentObject.open();
  };

  return (
    <div style={styles.container}>
      <h2 style={styles.title}>Invoice Preview</h2>
      <div style={styles.section}>
        <h3 style={styles.sectionTitle}>Vconfig</h3>
        <p>
          <strong>Order Date:</strong> {orderDate}
        </p>
      </div>
      <div style={styles.section}>
        <h3 style={styles.sectionTitle}>Product Details</h3>
        <p>
          <strong>Manufacturer:</strong> {manufacturer?.name || "N/A"}
        </p>
        <p>
          <strong>Model:</strong> {model?.name || "N/A"}
        </p>
        <p>
          <strong>Quantity:</strong> {quantity}
        </p>
      </div>
      <div style={styles.section}>
        <h3 style={styles.sectionTitle}>Selected Parts</h3>
        <ul style={styles.list}>
          {Object.values(selectedParts).map((part, index) => (
            <li key={index} style={styles.listItem}>
              {part.comp_name}
            </li>
          ))}
        </ul>
      </div>
      <div style={styles.section}>
        <h3 style={styles.sectionTitle}>Pricing Details</h3>
        <p>
          <strong>Base Price:</strong> ₹{basePrice.toLocaleString()}
        </p>
        <p>
          <strong>Tax (18%):</strong> ₹{tax.toLocaleString()}
        </p>
        <p>
          <strong>Total Price:</strong> ₹{totalprice.toLocaleString()}
        </p>
        <p>
          <strong>Final Total Price:</strong> ₹{ftp.toLocaleString()}
        </p>
      </div>
      <div style={styles.buttonContainer}>
        <button style={styles.button} onClick={displayRazorpay}>
          Proceed to Payment
        </button>
        <button style={styles.button} onClick={() => navigate("/SelectionPage")}>
          Cancel
        </button>
      </div>

      {/* Conditionally render the "Download Invoice" button */}
      {transactionId && (
        <div style={styles.buttonContainer}>
          <button style={styles.button} onClick={generatePDF}>
            Download Invoice
          </button>
        </div>
      )}
    </div>
  );
};

const styles = {
  container: {
    maxWidth: "800px",
    margin: "auto",
    padding: "30px",
    border: "1px solid #ddd",
    borderRadius: "10px",
    backgroundColor: "#fff",
    boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
  },
  title: {
    textAlign: "center",
    color: "#333",
    marginBottom: "20px",
  },
  section: {
    marginBottom: "20px",
    padding: "15px",
    borderBottom: "1px solid #eee",
  },
  sectionTitle: {
    color: "#007bff",
    marginBottom: "10px",
  },
  list: {
    listStyleType: "none",
    padding: 0,
  },
  listItem: {
    padding: "8px 0",
    borderBottom: "1px solid #eee",
  },
  buttonContainer: {
    display: "flex",
    justifyContent: "space-between",
    marginTop: "30px",
  },
  button: {
    padding: "12px 20px",
    border: "none",
    backgroundColor: "#007bff",
    color: "white",
    cursor: "pointer",
    borderRadius: "5px",
    fontSize: "14px",
    transition: "background-color 0.3s ease",
  },
};

export default InvoicePage;