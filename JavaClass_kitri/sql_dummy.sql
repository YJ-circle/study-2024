--SELECT concat('0',MAX(id)+1) FROM MEMBER;

-- 임의의 한글
CREATE OR REPLACE FUNCTION generate_random_korean_string(p_length NUMBER) RETURN VARCHAR2 IS
  v_result VARCHAR2(1000) := '';
  v_korean_chars VARCHAR2(1000) := '가각간갇갈감갑값갓갔강갖갗갘같갚갛개객갟갠갡갢갣갤갥갦갧갨갩갪갫갬갭갮갯갰갱갲갳갴갵갶갷갸갹갺갻갼갽갾갿걀걁걂걃걄걅걆걇걈걉걊걋걍걎걏걐걑걒걓걔걙걚걛걜걝걞걟걠걡걢걣걤걥걦걧걨걩걪걫걬걭걮걯거걱걲걳건걵걶걷걸걹걺걻걼걽걾걿걀걁걂걃걄걅걆걇걈걉걊걋걍걎걏걐걑걒걓걔걙걚걛걜걝걞걟걠걡걢걣걤걥걦걧걨걩걪걫걬걭걮걯';
BEGIN
  FOR i IN 1 .. p_length LOOP
    v_result := v_result || SUBSTR(v_korean_chars, DBMS_RANDOM.VALUE(1, LENGTH(v_korean_chars)), 1);
  END LOOP;
  RETURN v_result;
END;
/

-- 테스트 쿼리문
WITH random_korean AS (
    SELECT generate_random_korean_string(3) AS random_korean
    FROM DUAL
)
SELECT concat('0', MAX(id) + 1) AS id,
       random_korean as name,
       TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS coupon,
       TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS mile,
       'Y' as active
FROM MEMBER, random_korean;


-- INSERT
INSERT INTO MEMBER (id, name, coupon, mile, active)
WITH random_korean AS (
    SELECT generate_random_korean_string(3) AS random_korean
    FROM DUAL
)
SELECT concat('0', MAX(id) + 1) AS id,
       random_korean.random_korean AS name,
       TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS coupon,
       TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS mile,
       'Y' AS active
FROM MEMBER, random_korean;

-- 여러번 실행
BEGIN
  FOR i IN 1 .. 10000 LOOP
    INSERT INTO MEMBER (id, name, coupon, mile, active)
    SELECT concat('0', MAX(id) + 1) AS id,
           random_korean.random_korean AS name,
           TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS coupon,
           TRUNC(DBMS_RANDOM.VALUE(1, 5)) AS mile,
           'Y' AS active
    FROM MEMBER
    CROSS JOIN (SELECT generate_random_korean_string(3) AS random_korean FROM DUAL) random_korean;
  END LOOP;
  COMMIT; -- 모든 삽입 작업을 커밋
END;
/

-- 행 개수 가져오기
SELECT COUNT(*) AS total_rows
FROM member;


-- 시퀸스 사용
INSERT INTO loginlog(sn, name)
VALUES (seqlogin.NEXTVAL
           , 'ㅎㅎ')
