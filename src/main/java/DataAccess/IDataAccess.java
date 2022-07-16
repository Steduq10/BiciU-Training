package DataAccess;

import Bicycle.Ticket;
import Exceptions.DataAccessEx;
import Exceptions.DataWritingEx;
import Main.TicketsHistory;
import Person.Person;

import java.util.List;

public interface IDataAccess {

    boolean exists(String filename) throws DataAccessEx;
    void createFile(String fileName) throws DataAccessEx;
    void writeFile(String fileName, Ticket ticket, boolean anexar) throws DataWritingEx;
  //  void writeFile(String nombreArchivo, Stylist stylist, boolean anexar) throws DataWritingEx;
   // void writeFile(String nombreArchivo, Doctor doctor, boolean anexar) throws DataWritingEx;
    //List<Cat> list (String fileName) throws DataReadingEx;
    void create(String nombreArchivo) throws DataAccessEx;

    void remove (String nombreArchivo) throws DataAccessEx;


}
