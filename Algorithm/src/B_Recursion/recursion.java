package B_Recursion;

/*

*** base condition
[종료조건이 반드시 필요]

재귀호출 전
재귀호출  ( 한 함수에서 재귀 호출이 여러번일 수 있다. )
재귀호출 후


-----------------마지막 값을 전역변수에 넣거나, 사용(backtracking)
base condition 종료 때 값을 사용하고 싶다면 (다른 전역변수에 값을 넣어둠)
중간중간 저장은 backtracking 방식으로 자리수

void func(int n){
    if(n==5){
        인스턴스 변수 = n;
        return;
    }
    func(n+1);
    return;


-----------------마지막 값을 사용하고 싶을 때         [최종값을 계속 끌고옴]----------------
* base condition 값을 사용하고 싶다면 return 에 넣어둠.
* 모든 재귀가 종료될 때 계속 return 함

int func(int n){
    if( n == 5)
        return n;
    return func(n+1);     <------
}


-----------------재귀를 하며 중간 연산은 수정하지 않을 때
* return 은 정말 그 함수의 마지막임 함수가 한가지라고 생각.
* [입력 n이고, return n] 아무 변화가 없는 재귀함수

* 호출 입장에서 보면 n을 넣고, n을 돌려받은 것 뿐 // 재귀 함수 부르고 그냥 자신은 거쳐가는 것

int func(int n){
    func(n+1);
    return n
}

*/


/*
(별 찍기)
재귀를 이용해 2차원 arr 을 이용할 때
거시적인 idx 는 유지되며, 재귀될 때 마다 idx 를 맞추어 주면됨.
 */

public class recursion {
}
