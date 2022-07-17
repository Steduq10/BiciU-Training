package DataAccess;

import Bicycle.Ticket;
import Exceptions.DataAccessEx;
import Exceptions.DataReadingEx;
import Exceptions.DataWritingEx;
import Main.TicketsHistory;
import Person.Person;

import java.util.List;

public interface IDataAccess {

    boolean exists(String filename) throws DataAccessEx;
    void createFile(String fileName) throws DataAccessEx;
    void writeFile(String fileName, Ticket ticket, boolean anexar) throws DataWritingEx;
    void writeFile(String fileName, List<TicketsHistory> ticketFileList, boolean attach) throws DataWritingEx;
    void writeFile2(String fileName, List<String> header, boolean attach) throws DataWritingEx;

    void readFile(String fileName, List<String> array) throws DataReadingEx;



    void create(String nombreArchivo) throws DataAccessEx;

    void remove (String nombreArchivo) throws DataAccessEx;


}
