import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotterySimulation {
    public static void main(String[] args) {
        // 初始化参与抽奖的人员名单
        List<String> participants = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            participants.add("Person " + i);
        }

        // 定义奖品数量
        int numberOfPrizes = 6;
        List<String> winners = new ArrayList<>();

        // 创建随机数生成器
        Random random = new Random();

        // 抽奖过程
        while (numberOfPrizes > 0 && !participants.isEmpty()) {
            List<String> currentRoundWinners = new ArrayList<>();

            for (String participant : participants) {
                if (numberOfPrizes > 0) {
                    // 固定的中奖概率，可以根据需要调整
                    boolean isWinner = random.nextDouble() < ((double) numberOfPrizes / participants.size());

                    if (isWinner) {
                        currentRoundWinners.add(participant);
                        winners.add(participant);
                        numberOfPrizes--;
                    }
                } else {
                    break;
                }
            }

            // 从参与者列表中移除中奖者
            participants.removeAll(currentRoundWinners);
        }

        // 输出抽奖结果
        System.out.println("抽奖结果:");
        for (String winner : winners) {
            System.out.println("中奖者: " + winner);
        }

        // 输出未中奖者
        System.out.println("未中奖者:");
        for (String participant : participants) {
            System.out.println(participant);
        }
    }
}
