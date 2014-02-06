/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import business.system.ConfigureASystem;
import business.system.EcoSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

/**
 *
 * @author baochenhu
 */
public class DB4OUtil {

    //Change the FILENAME to the path where you have saved your DB4O serialization file
    private static final String FILENAME = "DataBank.db4o4";
    private static DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    /*
    * Reads the Db4O file and creates and returns an ObjectContainer object
    * @return ObjectContainer
    */
    private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true);

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    /*
     * Serializes and stores the {@code EcoSystem} object inside the DB4O database file
     */
    public synchronized void storeSystem(EcoSystem system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }
    
    /*
     * Reads and deserializes the {@code EcoSystem} object from DB4O database file and returns
     * the object
     * @return EcoSystem
     */
    public EcoSystem retrieveSystem(){
        ObjectContainer conn = createConnection();
        ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class);
        EcoSystem system;
        if (systems.size() == 0){
            system = ConfigureASystem.configure();
        }
        else{
            system = systems.get(systems.size()-1);
        }
        conn.close();
        return system;
    }
}
