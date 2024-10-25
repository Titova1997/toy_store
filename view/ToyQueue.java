package view;

import model.Toy;
import presenter.ConstructorToyShop;
import presenter.DollToyShop;
import presenter.RobotToyShop;
import presenter.ToyShop;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class ToyQueue {
    public void startApplication() {
        Queue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getWeight() - t1.getWeight());

        ToyShop constructorToyShop = new ConstructorToyShop();
        ToyShop robotToyShop = new RobotToyShop();
        ToyShop dollToyShop = new DollToyShop();

        toyQueue.add(constructorToyShop.createToy(1, 2, "конструктор"));
        toyQueue.add(robotToyShop.createToy(2, 2, "робот"));
        toyQueue.add(dollToyShop.createToy(3, 6, "кукла"));

        Random random = new Random();
        try {
            FileWriter writer = new FileWriter("C:\\Users\\gepat\\Documents\\Обучение в GeekBrains" +
                    "\\КР по блоку специализация\\a_toy_shop\\src\\result.txt", StandardCharsets.UTF_8);
            for (int i = 0; i < 10; i++) {
                int randomValue = random.nextInt(10) + 1;
                Toy toy;
                if (randomValue <= 2) {
                    toy = constructorToyShop.createToy(1, 2, "конструктор");
                } else if (randomValue <= 4) {
                    toy = robotToyShop.createToy(2, 2, "робот");
                } else {
                    toy = dollToyShop.createToy(3, 6, "кукла");
                }
                String result = "ID: " + toy.getId() + ", Weight: " + toy.getWeight() + ", Name: " + toy.getName() + "\n";
                writer.write(result);
            }
            writer.close();
            System.out.println("Результаты розыгрыша записаны в файл result.txt");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл.");
            e.printStackTrace();
        }
    }
}
