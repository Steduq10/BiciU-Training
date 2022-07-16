package DataAccess;

import Bicycle.Ticket;
import Exceptions.DataAccessEx;
import Exceptions.DataWritingEx;
import Main.TicketsHistory;
import Person.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DataAccessImpl implements IDataAccess{
    @Override
    public boolean exists(String filename) throws DataAccessEx {
        var file = new File(filename);
        return file.exists();
    }

    @Override
    public void createFile(String fileName) throws DataAccessEx {
        var file = new File(fileName);
        try {
            var out = new PrintWriter(new FileWriter(file));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataAccessEx("Exception:" + e.getMessage());
        }
    }

    @Override
    public void writeFile(String fileName, Ticket ticket, boolean attach) throws DataWritingEx {
        var file = new File(fileName);
        try {
            var out = new PrintWriter(new FileWriter(file, attach));
            out.println(ticket.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataWritingEx("Exception:" + e.getMessage());
        }
    }

    @Override
    public void writeFile(String fileName, List<TicketsHistory> ticketFileList, boolean attach) throws DataWritingEx {
        var file = new File(fileName);
        try {
            var out = new PrintWriter(new FileWriter(file, attach));
            out.println(ticketFileList.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataWritingEx("Exception:" + e.getMessage());
        }
    }



    @Override
    public void writeFile2(String fileName, List<String> header, boolean attach) throws DataWritingEx {
        var file = new File(fileName);
        try {
            var out = new PrintWriter(new FileWriter(file, attach));
            out.println(header.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataWritingEx("Exception:" + e.getMessage());
        }
    }

    @Override
    public void create(String fileName) throws DataAccessEx {
        var file = new File(fileName);
        try {
            var out = new PrintWriter(new FileWriter(file));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataAccessEx("Excepcion al crear el historial:" + e.getMessage());
        }
    }

    @Override
    public void remove(String fileName) throws DataAccessEx {
        var file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}
