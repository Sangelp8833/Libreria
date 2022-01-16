import java.util.Date;

public class Libro {

    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private Integer paginas;
    private Categoria categoria;
    private static int count;
    private Integer indice;



    public Libro(String titulo, String autor, Date fechaPublicacion, Integer paginas, Categoria categoria){
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.paginas = paginas;
        this.categoria = categoria;
        this.indice = ++count;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public Date getFechaPublicacion(){
        return this.fechaPublicacion;
    }

    public Integer getPaginas(){
        return this.paginas;
    }

    public Categoria getCategoria(){
        return this.categoria;
    }

    public Integer getIndice(){
        return  indice;
    }

    @Override
    public String toString(){
        return "El libro " +  this.titulo + " del genero " + this.categoria +
                " fue escrito por " + this.autor + " y publicado en " + this.fechaPublicacion.getYear();
    }


}
