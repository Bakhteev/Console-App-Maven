package View.ConsoleCommands;

public abstract class AbstractCommand implements ICommand {
    private String name;
    private String description;
    private String params;

    public AbstractCommand(String name, String description, String params) {
        this.name = name;
        this.description = description;
        this.params = params;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getParameters() {return params;}
}
