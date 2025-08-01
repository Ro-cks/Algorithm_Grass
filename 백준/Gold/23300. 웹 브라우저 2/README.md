# [Gold V] 웹 브라우저 2 - 23300 

[문제 링크](https://www.acmicpc.net/problem/23300) 

### 성능 요약

메모리: 22524 KB, 시간: 216 ms

### 분류

구현, 자료 구조, 스택, 덱

### 제출 일자

2025년 8월 2일 15:28:18

### 문제 설명

<p>우리는 웹 페이지에 접속할 때 '웹 브라우저'를 사용한다. 웹 브라우저에는 크게 <strong>뒤로 가기(Backward),</strong> <strong>앞으로 가기(Frontward)</strong>, <strong>웹페이지 접속(Access) </strong>기능이 있다.</p>

<p>사용자가 웹 사이트에 접속하면 컴퓨터의 캐시(cache)공간에 웹페이지 정보가 저장된다. 그리고 뒤로 가기 또는 앞으로 가기 기능을 사용하면 캐시 공간에 저장되어 있던 페이지의 정보를 불러오게 된다. 여기에 주헌이가 개발한 웹 브라우저에는 신기한 기능이 있는데, 바로 <strong>압축(Compress)</strong>이라는 기능이다. 압축 기능은 뒤로 가기 공간에 같은 번호의 페이지가 연속해서 들어있을 때, 이를 하나로 줄일 수 있는 기능이다.</p>

<p>각 기능의 작동방식은 각각 다음과 같다.</p>

<ul>
	<li>뒤로 가기를 실행할 경우</li>
</ul>

<ol style="list-style-position : inside">
	<li>뒤로 가기 공간에 1개 이상의 페이지가 저장되어 있을 때만 2,3번 과정이 실행된다. 0개일 때 이 작업은 무시된다.</li>
	<li>현재 보고 있던 웹페이지를 앞으로 가기 공간에 저장한다.</li>
	<li>뒤로 가기 공간에서 방문한지 가장 최근의 페이지에 접속한다. 그리고 해당 페이지는 뒤로 가기 공간에서 삭제된다.</li>
</ol>

<ul>
	<li>앞으로 가기를 실행할 경우</li>
</ul>

<ol style="list-style-position : inside">
	<li>앞으로 가기 공간에 1개 이상의 페이지가 저장되어 있을 때만 2,3번 과정이 실행된다. 0개일 때 이 작업은 무시된다.</li>
	<li>현재 보고 있던 페이지를 뒤로 가기 공간에 저장한다.</li>
	<li>앞으로 가기 공간에서 방문한지 가장 최근의 페이지에 접속한다. 그리고 해당 페이지는 앞으로 가기 공간에서 삭제된다.</li>
</ol>

<ul>
	<li>웹 페이지에 접속할 경우</li>
</ul>

<ol style="list-style-position : inside">
	<li><strong>앞으로 가기 공간에 저장된 페이지가 모두 삭제된다.</strong></li>
	<li>현재 페이지를 뒤로 가기 공간에 추가하고, 다음에 접속할 페이지가 현재 페이지로 갱신된다. 단, 처음으로 웹페이지에 접속하는 경우라면 현재 페이지를 뒤로 가기 공간에 추가하지 않는다.</li>
</ol>

<ul>
	<li>압축을 실행할 경우</li>
</ul>

<ol style="list-style-position : inside">
	<li><strong>뒤로 가기 공간</strong>에서 같은 번호의 페이지가 연속해서 2개 이상 등장할 경우, 가장 최근의 페이지 하나만 남기고 나머지는 모두 삭제한다.</li>
</ol>

<p><em>Q</em>개의 작업을 모두 마친 뒤에 현재 접속 중인 페이지와 뒤로 가기 공간, 앞으로 가기 공간에 저장되어 있는 페이지의 번호를 구하여라.</p>

<p><strong>초기 상태에는 뒤로가기 공간, 앞으로 가기 공간이 모두 비어있으며 어떤 페이지에도 접속해있지 않는 상태이다.</strong> 또한 같은 번호의 페이지에 여러번 접속할 수 있으며, 그럴 경우 같은 번호의 페이지이라도 방문 순서는 각기 다르게 취급된다. <strong>이 문제에서 컴퓨터의 캐시 용량은 충분히 크다고 가정한다.</strong></p>

### 입력 

 <p>첫째 줄에 접속할 수 있는 웹페이지의 종류의 수 <em>N</em>, 사용자가 수행하는 작업의 개수 <em>Q</em> 가 각각 주어진다.(1 ≤ <em>N, Q</em> ≤ 2,000)</p>

<p>둘째 줄부터는 <em>Q</em>개의 작업이 주어지며, 각 작업이 의미하는 바는 다음과 같다.</p>

<ul>
	<li>B : 뒤로 가기를 실행한다.</li>
	<li>F : 앞으로 가기를 실행한다.</li>
	<li>A <em>i</em> : <em>i </em>번 웹페이지에 접속한다.</li>
	<li>C : 압축을 실행한다.</li>
</ul>

<p><strong>A(접속)작업이 적어도 한 번은 등장한다.</strong></p>

### 출력 

 <p>3줄에 걸쳐서 출력한다.</p>

<p>첫째 줄에는 현재 접속 중인 페이지의 번호를 출력한다.</p>

<p>둘째 줄에는 뒤로 가기 공간에서 <strong>가장 최근에 방문한 순서대로</strong> 페이지의 번호를 출력한다. 저장된 페이지가 없다면 <strong><code>-1</code></strong> 을 출력한다.</p>

<p>셋째 줄에는 앞으로 가기 공간에서 <strong>가장 최근에 방문한 순서대로</strong> 페이지의 번호를 출력한다. 저장된 페이지가 없다면 <strong><code>-1</code></strong> 을 출력한다.</p>

