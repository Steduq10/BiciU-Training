package DataAccess;

import Exceptions.DataAccessEx;
import Exceptions.DataWritingEx;
import Person.Person;

import java.util.List;

public interface IDataAccess {

    boolean exists(String filename) throws DataAccessEx;
    void createFile(String fileName) throws DataAccessEx;
    void writeFile(String fileName, Person student, boolean anexar) throws DataWritingEx;
  //  void writeFile(String nombreArchivo, Stylist stylist, boolean anexar) throws DataWritingEx;
   // void writeFile(String nombreArchivo, Doctor doctor, boolean anexar) throws DataWritingEx;
    //List<Cat> list (String fileName) throws DataReadingEx;
    void create(String nombreArchivo) throws DataAccessEx;

    void remove (String nombreArchivo) throws DataAccessEx;


}
