package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;
import Model.Person;
import utils.FileWorker;
import utils.JSONParser;

import java.io.IOException;
import java.util.LinkedList;

public class SaveCommand extends AbstractCommand {
    FileWorker fileWorker;
    JSONParser jsonParser;
    LinkedListCollectionManager collectionManager;

    public SaveCommand(FileWorker fileWorker, JSONParser jsonParser, LinkedListCollectionManager collectionManager) {
        super("save", "saves collection data to file", "");
        this.fileWorker = fileWorker;
        this.jsonParser = jsonParser;
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            collectionManager.setLastSaveTime();
            fileWorker.saveFile(jsonParser.toJSON(collectionManager));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
