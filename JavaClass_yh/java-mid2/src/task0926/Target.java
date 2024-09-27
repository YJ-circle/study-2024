package task0926;

import java.util.Random;

public class Target {

    private String targetId;
    private boolean isExistPost;
    private int ballCnt;
    private double point;

    public Target(String targetId, boolean isExistPost, int ballCnt, double point) {
        this.targetId = targetId;
        this.isExistPost = isExistPost;
        this.ballCnt = ballCnt;
        this.point = point;
    }

    public String getTargetId() {
        return targetId;
    }

    public boolean isExistPost() {
        return isExistPost;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public double getPoint() {
        return point;
    }
    /*
    
    골대 클래스
    골대 아이디
    공의 개수
    공의 점수

    골대가 14개 -> 객체 배열로 저장

   List를 3개 만듬
   골대 아이디 리스트 : 14개
   공의 갯수 리스트 : 14개
   공의 점수 리스트 : 14개

   골대 없으면 공개수만큼 -점수
   골대가 있으면 기회를 준다.
   시도 여부 결정 가능 // 패널티 없음

   공은 +공이 있고, -공이 있다.


   골대를 5개 또는 10개를 뽑는다.
   프로그램 시작
   > 골대 5개 정해준다.
   >

     */
}
