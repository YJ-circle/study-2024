package task0926;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameMain {
    private static Random random = new Random();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" ============ HELLO -===========");
        System.out.print("게임을 시작하려면 아무 문자나 입력하세요.");
        sc.nextLine();
        System.out.println("게임 시작!!");

        Target[] gameInitInfoList = gameInitSetting();
        List<Result> resultList = new ArrayList<>();

        //5개 뽑기
        Target[] targetList = selectTarget(gameInitInfoList);

        System.out.println("골대 5개가 선정되었습니다.");

        int gameCount = 0;

        int totalScore = 0;
        for (Target target : targetList) {
            int ballCnt = target.getBallCnt();
            double point = target.getPoint();
            System.out.println(++gameCount + "번째 골대입니다.");
            System.out.println(target.getTargetId());
            Result result = null;

            if (target.isExistPost()) {
                if(target.getBallCnt() > 0){
                    int subgameCount = 0;
                    for (int i = 0; i < target.getBallCnt(); i++) {
                        result = new Result(gameCount + "번째 골대", ++subgameCount + "번째 게임", target.getTargetId());
                        System.out.print("공을 던지시겠습니까!? (Y: 예, N: 아니오) ");
                        String userSelect = sc.nextLine().toLowerCase();
                        if("y".equals(userSelect)){
                            System.out.println("공을 던졌습니다 !!");
                            Thread.sleep(1000);
                            System.out.println("-");
                            Thread.sleep(1000);
                            if(getThrowResult() > 0){
                                System.out.println("성공!");
                                result.addPoint(point);
                            }
                            else{
                                System.out.println("실패!");
                            }

                        } else{
                            System.out.println("공을 던지지 않기로 결정했습니다.");
                            resultList.add(result);
                            break;
                        }
                        resultList.add(result);
                    }
                } else {
                    result = new Result(gameCount + "번째 골대", "1번째 게임", target.getTargetId());
                    System.out.println("공이 없어요.");
                }
                System.out.println(gameCount + "게임 종료~");
            } else {
                System.out.println("Oops!! 골대가 없군요.");
                result = new Result(gameCount + "번째 골대", "1번째 게임", target.getTargetId());
                result.addPoint(-1);
                System.out.println("점수를 잃었어요.");
                Thread.sleep(1500);
                resultList.add(result);
            }

        }
        printResult(resultList);
        printTotalScore(resultList);
    }
    private static void printResult(List<Result> resultList){
        System.out.println();
        System.out.println("== 게임 결과 ==");
        for (Result result : resultList) {
            System.out.println(result.getGameId() + ", " +result.getSubGameId());
            System.out.println("획득 점수: " + result.getPoint());
        }
    }
    private static void printTotalScore(List<Result> resultList){
        int sum = 0;
        for (Result result : resultList) {
            sum += result.getPoint();
        }
        System.out.println("\n총 점수 : " + sum);
    }
    private static int getThrowResult(){
        return random.nextInt(3);
    }
    private static double mathScore(int ballCnt, double point) {
        return ballCnt*point;
    }

    private static Target[] selectTarget(Target[] targets) {
        int targetCnt = 5;
        Target[] targetList = new Target[targetCnt];
        for (int i = 0; i < targetCnt; i++) {
            targetList[i] = targets[random.nextInt(13)];
        }
        return targetList;
    }

    private static Target[] gameInitSetting(){
        String[] targetList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
        boolean[] postList = {true, false, true, false, false, false, true, true, true, true, false, true, true, true};
        int[] ballCnt =   {2,  2, 5,  1,  1,  1,  2, 3,   7, 2,  1, 3, 0, 3};
        double[] ballPointList = {5, -1, 3, -1, -1, -1, -2, 2, 0.5, 1, -1, 3, 0, 2};

        Target[] target = new Target[14];
        for (int i = 0; i < target.length; i++) {
            target[i] = new Target(targetList[i],
                    postList[i],
                    ballCnt[i],
                    ballPointList[0]);
        }
        return target;
    }
}
