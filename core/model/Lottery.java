package core.model;

import core.data.Client;
import core.data.Toy;
import core.data.ToysDistributor;

import java.util.*;

public class Lottery extends Mode {
    private List<Integer> id;
    private List<Short> chance;
    private int sumChance;
    private int count;

    public Lottery() {
        super("start", "start to drawing");
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        if (toys.getToys() == null) {
            System.out.println("for beging enter list");
            throw new NullPointerException();
        } else {
            System.out.print("enter yours name: ");
            String name = scanner.next().trim().strip();
            Client client = new Client(name);
            prepare(toys.getToys());
            List<String> resultLottery = new LinkedList<>();
            boolean game = true;
            do {
                System.out.println(name + " for drawing press ENTER");
                scanner.next();
                Toy result = toys.searchById(randomGeneration());
                System.out.println("Young winning \"" + result.getName() + "\"");
                resultLottery.add(result.getName());
                System.out.println("Number of left toys " + --count);
                if (toys.decreaseRemove(result)) prepare(toys.getToys());
                System.out.println("\nContinue the draw? Y/N");
                String ok = scanner.next().trim().strip().toLowerCase();
                if (!ok.equals("y")) game = false;
                if (count == 0){
                    game = false;
                    System.out.println("toys is missing");
                }
            } while (game);
            client.setWinning(resultLottery);
            client.writeToFile();
        }
    }

    public void prepare(Queue<Toy> toys) {
        id = new ArrayList<>();
        chance = new ArrayList<>();
        sumChance = 0;
        count = 0;
        for (Toy toy : toys) {
            this.id.add(toy.getId());
            this.chance.add(toy.getChanceFalling());
            this.sumChance += toy.getChanceFalling();
            this.count += toy.getQuantity();
        }
    }

    private int randomGeneration() {
        Random random = new Random();
        int index = random.nextInt(sumChance);
        for (int i = 0; i < chance.size(); i++) {
            index -= chance.get(i);
            if (index < 0) {
                return id.get(i);
            }
        }
        return -1;
    }
}
