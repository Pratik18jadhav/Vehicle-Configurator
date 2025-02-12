using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;


namespace backed_.NET.Models;

[Table("alternate_component")]
[Index("AltCompId", Name = "FKfrq37y1cv7my8kmj0d6f2m2ua")]
[Index("CompId", Name = "FKmf97r6xj5y8avpivxdgo4h8eh")]
[Index("ModelId", Name = "FKpicof3xyphodal8wq0mj6uquo")]
public partial class AlternateComponent
{
    [Key]
    [Column("alt_id")]
    public int AltId { get; set; }

    [Column("delta_price")]
    public double DeltaPrice { get; set; }

    [Column("alt_comp_id")]
    public int AltCompId { get; set; }

    [Column("comp_id")]
    public int CompId { get; set; }

    [Column("model_id")]
    public int ModelId { get; set; }

    [ForeignKey("AltCompId")]
    [InverseProperty("AlternateComponentAltComps")]
    public virtual Component AltComp { get; set; } = null!;

    [ForeignKey("CompId")]
    [InverseProperty("AlternateComponentComps")]
    public virtual Component Comp { get; set; } = null!;

    [ForeignKey("ModelId")]
    [InverseProperty("AlternateComponents")]
    public virtual Model Model { get; set; } = null!;
}
