package DataAccess;

import Bicycle.Ticket;
import Exceptions.DataAccessEx;
import Exceptions.DataReadingEx;
import Exceptions.DataWritingEx;
import Main.TicketsHistory;

import java.io.*;
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
    public void readFile(String fileName, List<String> array) throws DataReadingEx {
        File file = new File("bicycles data.txt");
        try {
            BufferedReader obj = new BufferedReader(new FileReader(file));
            String read;
            while ((read = obj.readLine()) != null ){
                //System.out.println(read);
                array.add(read);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
