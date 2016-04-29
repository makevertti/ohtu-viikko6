package statistics;

import statistics.matcher.*;

import java.util.ArrayList;
import java.util.List;

class QueryBuilder {
    private List<Matcher> matchers;

    QueryBuilder() {
        this.matchers = new ArrayList<>();
    }

    Matcher build() {
        Matcher builtMatcher = new And(this.matchers.toArray(new Matcher[]{}));
        matchers.clear();
        return builtMatcher;
    }

    QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }

    QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }

    QueryBuilder not(Matcher matcher) {
        this.matchers.add(new Not(matcher));
        return this;
    }

    QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }

    QueryBuilder or(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }
}
