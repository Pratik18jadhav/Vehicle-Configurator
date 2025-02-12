using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace backed_.NET.Models;

[Table("segment")]
public partial class Segment
{
    [Key]
    [Column("seg_id")]
    public int SegId { get; set; }

    [Column("seg_name")]
    [StringLength(255)]
    public string? SegName { get; set; }

    [InverseProperty("Seg")]
    public virtual ICollection<Manufacturer> Manufacturers { get; set; } = new List<Manufacturer>();

    [InverseProperty("Seg")]
    public virtual ICollection<Model> Models { get; set; } = new List<Model>();
}
