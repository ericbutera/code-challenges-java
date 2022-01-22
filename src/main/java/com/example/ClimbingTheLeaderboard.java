// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true
package com.example;

import jdk.jshell.execution.JdiExecutionControl;

import java.util.*;

/*
Notes:

find rank:
    using array:
        for (rank,rankscore) in ranks
            if gamescore >= rankscore return rank + 1
        return ranks.length + 1

    using hash:
        exact rank found:
        attempt = ranks[score]
        if attempt score >= attempt = first place
        if attempt score < attempt = last place

        rank not found, iterate
        for rank in ranks
            if score >= attempt => rank

create ranks:
    concept:
    x = 0
    ranks = []
    for score in ranked
        if score != ranks[x]
            ranks[x] = score
            x++
 */

public class ClimbingTheLeaderboard {
    /**
     * Find all of the rankings for a player over their games
     *
     * @param ranked current leaderboard scores in desc order
     * @param player (should be called game-scores) the player's game scores in asc order
     * @return player the player's rankings for the given game-scores
     */
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        var results = Arrays.asList(new Integer[player.size()]);
        var rankOffset = 0;
        var currentRank = 1;

        for (var playerOffset = player.size() - 1; playerOffset >= 0; playerOffset--) {
            var playerScore = player.get(playerOffset);
            var skipRank = 0;

            for (; rankOffset < ranked.size(); rankOffset++) {
                var rankScore = ranked.get(rankOffset);

                if (rankScore == skipRank) {
                    continue; // don't compare against a score more than once
                } else {
                    skipRank = rankScore;
                }

                if (playerScore > rankScore) {
                    break;
                } else if (playerScore.equals(rankScore)){
                    break;
                }

                currentRank++;
            }

            results.set(playerOffset, currentRank);
        }

        return results;
    }
}
