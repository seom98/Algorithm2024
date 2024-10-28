# [Gold IV] SAVE the World (Small) - 29007 

[문제 링크](https://www.acmicpc.net/problem/29007) 

### 성능 요약

메모리: 18104 KB, 시간: 244 ms

### 분류

애드 혹, 해 구성하기, 구현

### 제출 일자

2023년 8월 23일 17:18:01

### 문제 설명

<p><strong>본 문제와 Large 문제는 점수 계산식과 제한이 다르다. "제한" 문단을 참조하라.</strong></p>

<p>어느 날, 당신을 포함하여 총 $n+1$명의 용사가 이세계로 소환되었다. 당신은 용사들을 통솔할 수 있는 "지시" 능력을 부여받았다. 그러나 용사들이 이세계 곳곳에 흩어져 있기에, 마왕을 토벌하기 전 모든 용사가 한 곳에 집합할 필요가 있다. 따라서, 당신은 용사들이 당신이 있는 곳으로 집합할 수 있도록 그들 모두에게 "지시"를 내려야 한다.</p>

<p>이세계는 크기가 무한한 2차원 좌표평면으로 모델링할 수 있다. 당신은 현재 $(0,0)$에 있으며, 다른 모든 용사 또한 각각 서로 다른 정수 좌표 $(x,y)$에 있다. $(0,0)$에 있지 않은 모든 용사는 각 시점마다 자신의 좌표 $(x,y)$에 대해 $\max(|x'-x|,|y'-y|)=1$인 $(x',y')$로 이동해야 한다. 즉, 현재 어떤 용사가 $(x,y)$에 있다면, 이 용사는 $(x-1,y)$, $(x-1,y-1)$, $(x,y-1)$, $(x+1,y-1)$, $(x+1,y)$, $(x+1,y+1)$, $(x,y+1)$, $(x-1,y+1)$ 중 한 곳으로 이동해야만 한다.</p>

<p>용사들에게 지시를 내리는 방법은 다음과 같다. 각 순간, $(0,0)$에 있지 않은 모든 용사는 인접한 $8$개의 칸 중 하나로 이동해야 한다. 이때, 용사가 키보드의 $S$ 키에 있다고 가정하면 인접한 $8$개의 칸을 직관적으로 생각할 수 있을 것이다. 현재 용사가 $(x,y)$에 있다면, 인접한 칸 $8$개 각각에 대응하는 키보드의 알파벳은 다음과 같다.</p>

<table align="center" border="0" cellpadding="0" cellspacing="0" class="table table-bordered" style="width: 250px;">
	<tbody>
		<tr>
			<td>$A$</td>
			<td>$(x-1,y)$</td>
		</tr>
		<tr>
			<td>$Q$</td>
			<td>$(x-1,y+1)$</td>
		</tr>
		<tr>
			<td>$W$</td>
			<td>$(x,y+1)$</td>
		</tr>
		<tr>
			<td>$E$</td>
			<td>$(x+1,y+1)$</td>
		</tr>
		<tr>
			<td>$D$</td>
			<td>$(x+1,y)$</td>
		</tr>
		<tr>
			<td>$C$</td>
			<td>$(x+1,y-1)$</td>
		</tr>
		<tr>
			<td>$X$</td>
			<td>$(x,y-1)$</td>
		</tr>
		<tr>
			<td>$Z$</td>
			<td>$(x-1,y-1)$</td>
		</tr>
	</tbody>
</table>

<p>각 순간마다 하나의 알파벳을 정해 문자열로 합치면, 용사에 대한 "지시"가 된다. 예를 들어, $(1,1)$에 있는 용사에게 지시 $QXX$를 내리면 용사는 순서대로 $(0,2)$, $(0,1)$, $(0,0)$의 경로를 지나서 최종적으로 $(0,0)$에 도착할 것이다. 또한 $(-1,-1)$에 있는 용사에게 지시 $E$를 내리면 용사는 한 번에 $(0,0)$에 도착할 것이다. 용사 전체에 대한 지시는 각 용사와 그 용사에게 내리는 지시 간의 일대일 대응으로 정의된다.</p>

<p>그러나, 용사에 대한 사실은 아직 비밀에 부쳐져 있으며 용사를 소집시키는 작전 또한 아직 기밀이기에, 용사에게 지시를 내리는 것에는 다음과 같은 제약이 있다.</p>

<ul>
	<li>한 용사는 <strong>같은 좌표를 $2$번 이상 지날 수 없다.</strong> 다시 말해, 어느 순간에 용사가 좌표 $u$에서 좌표 $v$로 이동했다면, 그 용사는 좌표 $u$를 다시 방문할 수 없다.</li>
	<li>어느 순간에 <strong>$2$명 이상의 용사가 $(0,0)$을 제외한 어떤 좌표에 동시에 위치할 수 없다.</strong> 다시 말해, 어느 순간에 두 용사 A와 B가 좌표 $v$에 인접한 서로 다른 좌표에 있었다면, 두 용사가 동시에 좌표 $v$로 이동하는 것은 불가능하다. 단, 두 용사가 각각 좌표 $u$와 $v$를 차지하여, 어느 순간에 <strong>자리를 바꾸어 각각 $v$와 $u$로 이동하는 것은 가능하다.</strong></li>
	<li>모든 용사는 <strong>동시에</strong> 현재 순간의 지시에 해당하는 다음 좌표로 이동해야 한다. 다시 말해, 현재가 순간 $i$라면, $(0,0)$에 있는 용사들을 제외한 모든 용사는 자신의 지시에서 $i$번째 알파벳에 해당하는 좌표로 이동해야 한다.</li>
	<li>어떤 용사가 <strong>$(0,0)$에 도착한 이후부터는 더 이상 그 용사에게 지시를 내리면 안 된다.</strong></li>
	<li>어느 순간에 $2$명 이상의 용사가 <strong>동시에 $(0,0)$으로 이동할 수 없다. </strong>다시 말해, 어떤 순간에 $(0,0)$에 도착하는 용사는 반드시 $1$명이거나 $0$명이어야 한다.</li>
</ul>

<p>예시를 들어 보자. 당신을 제외한 용사들이 현재 $(1,-1)$, $(1,0)$, $(1,1)$에 있다고 가정하자. 이때 다음은 정당한 지시의 예시이다.</p>

<table align="center" border="0" cellpadding="0" cellspacing="0" class="table table-bordered" style="width: 250px;">
	<tbody>
		<tr>
			<td>$(1,-1)$</td>
			<td>$Q$</td>
		</tr>
		<tr>
			<td>$(1,0)$</td>
			<td>$QX$</td>
		</tr>
		<tr>
			<td>$(1,1)$</td>
			<td>$CAA$</td>
		</tr>
	</tbody>
</table>

<p style="text-align: center;">예시 1. 정당한 지시의 예시</p>

<p>그러나, 다음은 제약을 만족하지 않는 지시들과, 그 지시들이 제약을 만족하지 않는 이유이다.</p>

<table align="center" border="0" cellpadding="0" cellspacing="0" class="table table-bordered" style="width: 250px;">
	<tbody>
		<tr>
			<td>$(1,-1)$</td>
			<td>$WA$</td>
		</tr>
		<tr>
			<td>$(1,0)$</td>
			<td>$A$</td>
		</tr>
		<tr>
			<td>$(1,1)$</td>
			<td>$XA$</td>
		</tr>
	</tbody>
</table>

<p style="text-align: center;">예시 2. 두 용사가 순간 $1$에 동시에 $(1,0)$을 차지하고 있다.</p>

<table align="center" border="0" cellpadding="0" cellspacing="0" class="table table-bordered" style="width: 250px;">
	<tbody>
		<tr>
			<td>$(1,-1)$</td>
			<td>$Q$</td>
		</tr>
		<tr>
			<td>$(1,0)$</td>
			<td>$WZ$</td>
		</tr>
		<tr>
			<td>$(1,1)$</td>
			<td>$Z$</td>
		</tr>
	</tbody>
</table>

<p style="text-align: center;">예시 3. 두 용사가 순간 $1$에 동시에 $(0,0)$으로 이동하고 있다.</p>

<table align="center" border="0" cellpadding="0" cellspacing="0" class="table table-bordered" style="width: 250px;">
	<tbody>
		<tr>
			<td>$(1,-1)$</td>
			<td>$XDQQ$</td>
		</tr>
		<tr>
			<td>$(1,0)$</td>
			<td>$A$</td>
		</tr>
		<tr>
			<td>$(1,1)$</td>
			<td>$AX$</td>
		</tr>
	</tbody>
</table>

<p style="text-align: center;">예시 4. 한 용사가 $(1,-1)$을 $2$번 지나가고 있다.</p>

<p>다만, 다음 지시는 정당한 지시이다.</p>

<table align="center" border="0" cellpadding="0" cellspacing="0" class="table table-bordered" style="width: 250px;">
	<tbody>
		<tr>
			<td>$(1,-1)$</td>
			<td>$WA$</td>
		</tr>
		<tr>
			<td>$(1,0)$</td>
			<td>$XAW$</td>
		</tr>
		<tr>
			<td>$(1,1)$</td>
			<td>$Z$</td>
		</tr>
	</tbody>
</table>

<p style="text-align: center;">예시 5. 두 용사가 순간 $1$에 서로 자리를 바꾸었지만, 여전히 이 지시는 정당한 지시이다.</p>

<p>과연 당신은 충분히 빠른 시간 안에 모든 용사를 $(0,0)$으로 집합시킬 수 있을까?</p>

### 입력 

 <p>첫 번째 줄에 당신을 제외한 용사의 수 $n$이 주어진다.</p>

<p>두 번째 줄부터 $n+1$번째 줄까지 용사의 좌표에 해당하는 값 $x_i$, $y_i$가 각각 공백으로 분리되어 주어진다.</p>

### 출력 

 <p>$i$번째 줄에 $i$번째 용사에게 내릴 지시를 문자열로 출력한다.</p>

