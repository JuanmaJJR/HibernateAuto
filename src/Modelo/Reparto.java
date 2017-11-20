package Modelo;
// default package
// Generated Nov 20, 2017 4:05:14 PM by Hibernate Tools 5.2.6.Final

/**
 * Reparto generated by hbm2java
 */
public class Reparto implements java.io.Serializable {

	private Integer codigo;
	private Actores actores;
	private Peliculas peliculas;
	private String tipoPapel;

	public Reparto() {
	}

	public Reparto(String tipoPapel) {
		this.tipoPapel = tipoPapel;
	}

	public Reparto(Actores actores, Peliculas peliculas, String tipoPapel) {
		this.actores = actores;
		this.peliculas = peliculas;
		this.tipoPapel = tipoPapel;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Actores getActores() {
		return this.actores;
	}

	public void setActores(Actores actores) {
		this.actores = actores;
	}

	public Peliculas getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(Peliculas peliculas) {
		this.peliculas = peliculas;
	}

	public String getTipoPapel() {
		return this.tipoPapel;
	}

	public void setTipoPapel(String tipoPapel) {
		this.tipoPapel = tipoPapel;
	}

}
