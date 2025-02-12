using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace backed_.NET.Models;

[Table("manufacturer")]
[Index("SegId", Name = "FKa91vd0u6phxic78difo3yejmo")]
public partial class Manufacturer
{
    [Key]
    [Column("mfg_id")]
    public int MfgId { get; set; }

    [Column("mfg_name")]
    [StringLength(255)]
    public string MfgName { get; set; } = null!;

    [Column("seg_id")]
    public int SegId { get; set; }

    [InverseProperty("Mfg")]
    public virtual ICollection<Model> Models { get; set; } = new List<Model>();

    [ForeignKey("SegId")]
    [InverseProperty("Manufacturers")]
    public virtual Segment Seg { get; set; } = null!;
}
