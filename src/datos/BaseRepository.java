package datos;

import equipo0_dominio.EntityBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Clase padre de los repositorios, responsable del acceso a datos.
 * @author felixalfonso
 */
abstract class BaseRepository<T extends EntityBase> {
    protected final EntityManager em;
    protected String clsName;
    protected final Class<T> cls;

    /**
     * Método constructor del acceso a datos.
     * @param em Entidad manejadora de la base de datos.
     * @param cls Clase del tipo del que se desea acceder a los datos.
     */
    public BaseRepository(EntityManager em, Class<T> cls) {
        this.em = em;
        if(cls.getName().contains(".")){
            this.clsName=cls.getName().split("\\.")[1];
        }else{
            this.clsName=cls.getName();
        }
        this.cls=cls;
    }
    
    /**
     * Método para obtener una instancia con el mismo id recibido por parámetro.
     * @param id Id de la instancia que se desea buscar.
     * @return Instancia encontrada.
     */
    public T buscar(int id) {
        T entity = this.em.find(cls, id);
        this.em.refresh(entity);
        return entity;
    }
    
    /**
     * Método para obtener todas las instancias de un tipo.
     * @return Lista con todas las instancias encontradas.
     */
    public List<T> buscarTodos(){
        List lst= this.em.createQuery("SELECT p FROM "+clsName+" p").getResultList();
        for (Object object : lst) {
            this.em.refresh(object);
        }
        return lst;
    }
    
    /**
     * Método para insertar una entidad en la base de datos.
     * @param entity La entidad que se desea guardar.
     * @return La entidad guardada en la base de datos.
     */
    public T guardar(T entity) {
        this.ensureTransaction();
        System.out.println("llegando: "+entity.getId());
        if (entity.getId() == null) {
            this.em.persist(entity);
            this.commit();
            return entity;
        } else {
            entity=this.em.merge(entity);
            this.commit();
            return entity;
        }
    }

    /**
     * Método para eliminar una entidad de la base de datos.
     * @param entity La entidad que se desea eliminar.
     */
    public void eliminar(T entity) {
        this.ensureTransaction();
        this.em.remove(entity);
        this.commit();
    }

    /**
     * Método para realizar los commits en la base de datos.
     */
    public void commit() {
        EntityTransaction transaction = this.em.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }
    
    /**
     * Método para asegurarse de que la transacción está activa.
     */
    protected void ensureTransaction() {
        EntityTransaction transaction = this.em.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }
}
