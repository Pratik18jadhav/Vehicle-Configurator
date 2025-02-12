using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace backed_.NET.Models;

[Table("invoicedto")]
[Index("UserName1", Name = "FKef385crv7994g0ck2v85se21p")]
public partial class Invoicedto
{
    [Key]
    [Column("id")]
    public long Id { get; set; }

    [Column("invoice_number")]
    [StringLength(255)]
    public string InvoiceNumber { get; set; } = null!;

    [Column("base_price")]
    public double BasePrice { get; set; }

    [Column("final_total_price")]
    public double FinalTotalPrice { get; set; }

    [Column("manufacturer")]
    [StringLength(255)]
    public string Manufacturer { get; set; } = null!;

    [Column("model_name")]
    [StringLength(255)]
    public string ModelName { get; set; } = null!;

    [Column("quantity")]
    public int Quantity { get; set; }

    [Column("segment")]
    [StringLength(255)]
    public string Segment { get; set; } = null!;

    [Column("tax")]
    public double Tax { get; set; }

    [Column("total_price")]
    public double TotalPrice { get; set; }

    [Column("username")]
    [StringLength(255)]
    public string? Username { get; set; }

    [Column("user_name")]
    public string UserName1 { get; set; } = null!;

    [ForeignKey("UserName1")]
    [InverseProperty("Invoicedtos")]
    public virtual Userdto UserName1Navigation { get; set; } = null!;
}
