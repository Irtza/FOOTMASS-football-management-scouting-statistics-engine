# FOOTMASS-football-management-scouting-statistics-engine
Football team management, Performance data collection, Scouting (user defined heuristics), and statistics (Player and team Performance Reports)

This was an ambitious Academic project, for Object Oriented Analysis and Design course, I continued to do some work on improving it.

This is a tool to help a League's Teams .. 
	1) manage its players, (Squad) All managers in the league can manage all their Players. uses simple Authorization.
	2) collect their performance Data in a live match.
	3) generate performance Reports about Individuals(Player). A manager and Coach can do that for their team.
	4) generate performance Reports about Team (Club). A manager and Coach can do that for their team.
	5) Scout players in that league based on given search heuristics. A scout does that.
	6) Transfer Players Between Clubs. A Manager places a Transfer Request, A Transfer agent Processess it through then commit is made.

Note that this is a simulation and although possible for slow match(video) playback, 
it will not be feasible to capture real LIVE data for all the players in match. So Centralization of software and 
concurrency can be an improvement. for obvious reasons this has been left as is. 

Concurrency:
Concurrency of Match Analysts'. "Match Analysis and Data Recording" Feature, can be a major improvement/contribution in getting
nearer to capturing real LIVE performance data of all 21 players on the field. 

Please note, There are issues with Scout's Scouting functionality, on that part the code is not tested throughly.
A Nullpointer Exception and a few other things need to be handled.

Co-Author of this is Nauman Hayat.
The Sample data. English Premier Leaugue has been obtained from Openfootball at Github. 
