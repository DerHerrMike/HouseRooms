package at.mps.app.builder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("resources/houses.csv");

        String streetname = streetNameInput();
        int number = numberInput();

        List<Wall> wallList = getWalls();
        Basement basement = new Basement.Builder().areas(askAreas())
                .flooring(askFlooringType())
                .build();
        Kitchen kitchen = new Kitchen.Builder().sqrm(sqrmInput())
                .windowNumber(windowNumberInput())
                .manufacturer(inputKitchenManfucterer())
                .build();
        Reception reception = new Reception.Builder().sqrm(sqrmInput())
                .doors(doorNumberInput())
                .furnitureList(inputReceptionItems())
                .build();
        Bedroom bedroom = new Bedroom.Builder().sqrm(sqrmInput())
                .name(inputOccName())
                .build();
        Dims dims = new Dims.Builder().width(dimWidthInput())
                .length(dimLengthInput())
                .height(dimHeightInput())
                .build();
        Chimney chimney = new Chimney.Builder().dims(dims)
                .color(inputChimneyColor())
                .build();
        Roof roof = new Roof.Builder().tiles(tileNumberInput())
                .age(roofAgeInput())
                .color(inputRoofColor())
                .chimney(chimney)
                .build();
        House ourHouse = new House.Builder().streetName(streetname)
                .number(number)
                .walls(wallList)
                .basement(basement)
                .kitchen(kitchen)
                .reception(reception)
                .bedroom(bedroom)
                .roof(roof)
                .build();

        writeFile(path, ourHouse);
    }

    public static String convert(House house) {

        return house.getStreetName() +
                "," +
                house.getNumber() +
                "," +
                house.getWalls().get(0).getDirection()+
                "," +
                house.getWalls().get(1).getDirection()+
                "," +
                house.getWalls().get(2).getDirection()+
                "," +
                house.getWalls().get(3).getDirection()+
                "," +
                house.getBasement().getAreas()+
                "," +
                house.getBasement().getFlooring()+
                "," +
                house.getKitchen().getSqrm()+
                "," +
                house.getKitchen().getManufacturer()+
                "," +
                house.getKitchen().getWindowNumber()+
                "," +
                house.getReception().getSqrm()+
                "," +
                house.getReception().getDoors()+
                "," +
                house.getReception().getFurnitureList()+
                "," +
                house.getBedroom().getSqrm()+
                "," +
                house.getBedroom().getName()+
                "," +
                house.getRoof().getTiles() +
                "," +
                house.getRoof().getColor() +
                "," +
                house.getRoof().getAge() +
                "," +
                house.getRoof().getChimney().getDims().getWidth() +
                "," +
                house.getRoof().getChimney().getDims().getLength() +
                "," +
                house.getRoof().getChimney().getDims().getHeight() +
                "," +
                house.getRoof().getChimney().getColor() +
                "\n";
    }

    public static void writeFile(Path path, House house) throws IOException {
        String object = convert(house);

        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        Files.write(
                path,
                object.getBytes(),
                StandardOpenOption.APPEND);
    }



    private static String streetNameInput() {

        System.out.println("Insert street name: ");
        return scanner.nextLine();
    }

    private static int numberInput() {
        System.out.println("Insert street number: ");
        return Integer.parseInt(scanner.nextLine());
    }


    //WALLS
    private static String inputDirectionWall1() {
        System.out.println("Insert direction wall1: ");
        return scanner.nextLine();
    }

    private static String inputDirectionWall2() {
        System.out.println("Insert direction wall2: ");
        return scanner.nextLine();
    }

    private static String inputDirectionWall3() {
        System.out.println("Insert direction wall3: ");
        return scanner.nextLine();
    }

    private static String inputDirectionWall4() {
        System.out.println("Insert direction wall4: ");
        return scanner.nextLine();
    }

    private static List<Wall> getWalls() {

        Wall wall1 = new Wall.Builder().direction(inputDirectionWall1())
                .build();

        Wall wall2 = new Wall.Builder().direction(inputDirectionWall2())
                .build();

        Wall wall3 = new Wall.Builder().direction(inputDirectionWall3())
                .build();

        Wall wall4 = new Wall.Builder().direction(inputDirectionWall4())
                .build();
        List<Wall> walllist = new ArrayList<>();
        walllist.add(wall1);
        walllist.add(wall2);
        walllist.add(wall3);
        walllist.add(wall4);
        return walllist;
    }

    //BASEMENT
    private static int askAreas() {
        System.out.println("Insert number of areas in basement: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String askFlooringType() {
        System.out.println("Insert kind of floor: ");
        return scanner.nextLine();
    }


    //BEDROOM
    private static int sqrmInput() {
        System.out.println("Please enter size in square meter: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String inputOccName() {
        System.out.println("Insert name of occupant: ");
        return scanner.nextLine();
    }

    private static int windowNumberInput() {
        System.out.println("Please enter number of windows: ");
        return Integer.parseInt(scanner.nextLine());
    }

    //Kitchen
    private static String inputKitchenManfucterer() {
        System.out.println("Insert name of kitchen manuf: ");
        return scanner.nextLine();
    }

    //Reception
    private static int doorNumberInput() {
        System.out.println("Please enter number of doors in reception: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static List<String> inputReceptionItems() {
        List<String> receptionItemsList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            System.out.println("Insert reception item to add to list: ");
            receptionItemsList.add(scanner.nextLine());
        }

        return receptionItemsList;
    }

    //DIMS
    private static int dimWidthInput() {
        System.out.println("Please enter width in meter: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int dimHeightInput() {
        System.out.println("Please enter height in meter: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int dimLengthInput() {
        System.out.println("Please enter length in meter: ");
        return Integer.parseInt(scanner.nextLine());
    }


    //CHIMNEY
    private static String inputChimneyColor() {
        System.out.println("Insert color of chimney: ");
        return scanner.nextLine();
    }


    //ROOF
    private static int tileNumberInput() {
        System.out.println("Please enter number of tiles on roof: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int roofAgeInput() {
        System.out.println("Please enter age of roof: ");
        return Integer.parseInt(scanner.nextLine());
    }


    private static String inputRoofColor() {
        System.out.println("Insert color of roof: ");
        return scanner.nextLine();

    }


}
