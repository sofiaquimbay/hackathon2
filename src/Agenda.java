import java.sql.Array;
import java.util.ArrayList;

public  class Agenda {
    public ArrayList<Contacto> listaContactos ;
    private int tamanioAgenda;




    public Agenda(int tamanioAgenda) {
        listaContactos = new ArrayList<>(tamanioAgenda);
        this.tamanioAgenda = tamanioAgenda;
    }

    public boolean aniadirContacto(Contacto contactoNuevo){
        if(!existeContacto(contactoNuevo) && !agendaLlena()){
            listaContactos.add(contactoNuevo);
            return true;
        }else{
            return false;
        }
    }

    public boolean existeContacto(Contacto contactoValidar){
        for( Contacto contacto : listaContactos){
            if(contacto.getNombre().equals(contactoValidar.getNombre())){
                return true;
            }
        }
        return false;
    }

    public void listarContacto(){
        if(listaContactos.isEmpty()) System.out.println("Su agenda esta vacía");
        else{
            for (Contacto contacto : listaContactos){
                System.out.println("Nombre: " + contacto.getNombre()+"\nTeléfono: " + contacto.getNumero() +"\n");
            }
        }

    }

    public Contacto buscaContacto(String nombre) throws MyException{
        for (Contacto contacto : listaContactos){
            if(contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        throw new MyException("El contacto no existe");
    }


    public boolean eliminarContacto(Contacto contactoEliminar){
        listaContactos.remove(contactoEliminar);
        return true;
    }

    public boolean agendaLlena(){
        return listaContactos.size() >= tamanioAgenda;
    }

    public int espacioLibres(){
        int espaciosDisponibles = tamanioAgenda - listaContactos.size();
        return espaciosDisponibles;
    }
}
