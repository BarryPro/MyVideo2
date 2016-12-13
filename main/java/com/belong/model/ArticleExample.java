package com.belong.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAidIsNull() {
            addCriterion("Aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("Aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("Aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("Aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("Aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("Aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("Aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("Aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("Aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("Aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("Aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("Uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("Uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("Uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("Uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("Uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("Uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("Uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("Uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("Uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("Uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("Uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andArootidIsNull() {
            addCriterion("Arootid is null");
            return (Criteria) this;
        }

        public Criteria andArootidIsNotNull() {
            addCriterion("Arootid is not null");
            return (Criteria) this;
        }

        public Criteria andArootidEqualTo(Integer value) {
            addCriterion("Arootid =", value, "arootid");
            return (Criteria) this;
        }

        public Criteria andArootidNotEqualTo(Integer value) {
            addCriterion("Arootid <>", value, "arootid");
            return (Criteria) this;
        }

        public Criteria andArootidGreaterThan(Integer value) {
            addCriterion("Arootid >", value, "arootid");
            return (Criteria) this;
        }

        public Criteria andArootidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Arootid >=", value, "arootid");
            return (Criteria) this;
        }

        public Criteria andArootidLessThan(Integer value) {
            addCriterion("Arootid <", value, "arootid");
            return (Criteria) this;
        }

        public Criteria andArootidLessThanOrEqualTo(Integer value) {
            addCriterion("Arootid <=", value, "arootid");
            return (Criteria) this;
        }

        public Criteria andArootidIn(List<Integer> values) {
            addCriterion("Arootid in", values, "arootid");
            return (Criteria) this;
        }

        public Criteria andArootidNotIn(List<Integer> values) {
            addCriterion("Arootid not in", values, "arootid");
            return (Criteria) this;
        }

        public Criteria andArootidBetween(Integer value1, Integer value2) {
            addCriterion("Arootid between", value1, value2, "arootid");
            return (Criteria) this;
        }

        public Criteria andArootidNotBetween(Integer value1, Integer value2) {
            addCriterion("Arootid not between", value1, value2, "arootid");
            return (Criteria) this;
        }

        public Criteria andAdateIsNull() {
            addCriterion("Adate is null");
            return (Criteria) this;
        }

        public Criteria andAdateIsNotNull() {
            addCriterion("Adate is not null");
            return (Criteria) this;
        }

        public Criteria andAdateEqualTo(Date value) {
            addCriterion("Adate =", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateNotEqualTo(Date value) {
            addCriterion("Adate <>", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateGreaterThan(Date value) {
            addCriterion("Adate >", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateGreaterThanOrEqualTo(Date value) {
            addCriterion("Adate >=", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateLessThan(Date value) {
            addCriterion("Adate <", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateLessThanOrEqualTo(Date value) {
            addCriterion("Adate <=", value, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateIn(List<Date> values) {
            addCriterion("Adate in", values, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateNotIn(List<Date> values) {
            addCriterion("Adate not in", values, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateBetween(Date value1, Date value2) {
            addCriterion("Adate between", value1, value2, "adate");
            return (Criteria) this;
        }

        public Criteria andAdateNotBetween(Date value1, Date value2) {
            addCriterion("Adate not between", value1, value2, "adate");
            return (Criteria) this;
        }

        public Criteria andVidIsNull() {
            addCriterion("Vid is null");
            return (Criteria) this;
        }

        public Criteria andVidIsNotNull() {
            addCriterion("Vid is not null");
            return (Criteria) this;
        }

        public Criteria andVidEqualTo(Integer value) {
            addCriterion("Vid =", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidNotEqualTo(Integer value) {
            addCriterion("Vid <>", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidGreaterThan(Integer value) {
            addCriterion("Vid >", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Vid >=", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidLessThan(Integer value) {
            addCriterion("Vid <", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidLessThanOrEqualTo(Integer value) {
            addCriterion("Vid <=", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidIn(List<Integer> values) {
            addCriterion("Vid in", values, "vid");
            return (Criteria) this;
        }

        public Criteria andVidNotIn(List<Integer> values) {
            addCriterion("Vid not in", values, "vid");
            return (Criteria) this;
        }

        public Criteria andVidBetween(Integer value1, Integer value2) {
            addCriterion("Vid between", value1, value2, "vid");
            return (Criteria) this;
        }

        public Criteria andVidNotBetween(Integer value1, Integer value2) {
            addCriterion("Vid not between", value1, value2, "vid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}