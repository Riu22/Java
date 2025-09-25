import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class publicacio{
    Date data_publicacio;
    int numpag;

    publicacio(int numpag, Date data_publicacio){
        this.numpag =numpag;
        this.data_publicacio = data_publicacio;
    }

    void setnumpag(int n){
        if (n>0&&n<1000){
            this.numpag =n;
        }
    }

    public void mostrardetalls() {
    }
}
class llibre extends publicacio{
    String nom_llibre;
    String ISBN;

    llibre(String nom_llibre, String ISBN, Date data_publicacio, int numpag){
        super(numpag,data_publicacio);
        this.ISBN =ISBN;
        this.nom_llibre = nom_llibre;
    }

    @Override
    public void mostrardetalls() {
    }
}

class revista extends publicacio{
    String nom_revista;

    revista(String nom_revista, Date data_publicacio, int numpag){
        super(numpag,data_publicacio);
        this.nom_revista = nom_revista;
    }

    @Override
    public void mostrardetalls() {
    }
}

class biblioteca{
     List<publicacio> publicacios = new ArrayList<>();

     void new_publicacion(publicacio p){
         this.publicacios.add(p);
     }

     void show_publicacio(){
         for(publicacio p: this.publicacios){
             p.mostrardetalls();
         }
     }
}
