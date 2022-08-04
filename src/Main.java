import com.trafimchuk.veranika.excs.exception.InvalidFormatException;
import com.trafimchuk.veranika.excs.exception.NoSuchOperationException;
import com.trafimchuk.veranika.excs.exception.ParserDataException;
import com.trafimchuk.veranika.excs.model.Data;
import com.trafimchuk.veranika.excs.service.ParserService;
import com.trafimchuk.veranika.excs.service.ReaderService;
import com.trafimchuk.veranika.excs.service.WriterService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String input = "resources/file_in.txt";
        String out = "resources/file_out.txt";

        ReaderService readerService;
        WriterService writerService;

        List<Data> dataList;

        try {
            readerService = new ReaderService(input, new ParserService());
            dataList = readerService.takeDataList();
            writerService = new WriterService(out, dataList);
            boolean finish = writerService.save();
            System.out.println(finish);


        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (ParserDataException e) {
            e.printStackTrace();
        }
    }
}
