# FOOTMASS-football-management-scouting-statistics-engine
Football team management, Performance data collection, Scouting (user defined heuristics), and statistics (Player and team Performance Reports)

This is a tool to help a League's Teams ..<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;1) manage its players, (Squad) All managers in the league can manage all their Players. uses simple Authorization.<br>
&nbsp;&nbsp;&nbsp;&nbsp;2) collect their performance Data in a live match.<br>
&nbsp;&nbsp;&nbsp;&nbsp;3) generate performance Reports about Individuals(Player). A manager and Coach can do that for their team.<br>
&nbsp;&nbsp;&nbsp;&nbsp;4) generate performance Reports about Team (Club). A manager and Coach can do that for their team.<br>
&nbsp;&nbsp;&nbsp;&nbsp;5) Scout players in that league based on given search heuristics. A scout does that.<br>
&nbsp;&nbsp;&nbsp;&nbsp;6) Transfer Players Between Clubs. A Manager places a Transfer Request, A Transfer agent Processess it through then commit is made.<br>
	<br>
Note that this is a simulation and although possible for slow match(video) playback, it will not be feasible to capture real LIVE data for all the players in match. So Centralization of software and 
concurrency can be an improvement. for obvious reasons this has been left as is. 
<br>
Concurrency:<br>
Concurrency of Match Analysts'. "Match Analysis and Data Recording" Feature, can be a major improvement/contribution in getting nearer to capturing real LIVE performance data of all 21 players on the field. 
<br>
Please note, There are issues with Scout's Scouting functionality, on that part the code is not tested throughly.
A Nullpointer Exception and a few other things need to be handled.
<br>
Co-Author of this is Nauman Hayat.
The Sample data. English Premier Leaugue has been obtained from Openfootball at Github. 
<br>
