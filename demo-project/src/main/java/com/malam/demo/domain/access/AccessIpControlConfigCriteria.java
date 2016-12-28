package com.malam.demo.domain.access;

import java.util.ArrayList;
import java.util.List;

public class AccessIpControlConfigCriteria {
    /**
     * access_ip_control_config表的操作属性:orderByClause
     * 
     */
    protected String orderByClause;

    /**
     * access_ip_control_config表的操作属性:start
     * 
     */
    protected int start;

    /**
     * access_ip_control_config表的操作属性:limit
     * 
     */
    protected int limit;

    /**
     * access_ip_control_config表的操作属性:distinct
     * 
     */
    protected boolean distinct;

    /**
     * access_ip_control_config表的操作属性:oredCriteria
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * access_ip_control_config数据表的操作方法: AccessIpControlConfigCriteria  
     * 
     */
    public AccessIpControlConfigCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * access_ip_control_config数据表的操作方法: setOrderByClause  
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * access_ip_control_config数据表的操作方法: getOrderByClause  
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * access_ip_control_config数据表的操作方法: setStart  
     * 
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * access_ip_control_config数据表的操作方法: getStart  
     * 
     */
    public int getStart() {
        return start;
    }

    /**
     * access_ip_control_config数据表的操作方法: setLimit  
     * 
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * access_ip_control_config数据表的操作方法: getLimit  
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * access_ip_control_config数据表的操作方法: setDistinct  
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * access_ip_control_config数据表的操作方法: isDistinct  
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * access_ip_control_config数据表的操作方法: getOredCriteria  
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * access_ip_control_config数据表的操作方法: or  
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * access_ip_control_config数据表的操作方法: or  
     * 
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * access_ip_control_config数据表的操作方法: createCriteria  
     * 
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * access_ip_control_config数据表的操作方法: createCriteriaInternal  
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * access_ip_control_config数据表的操作方法: clear  
     * 
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * access_ip_control_config表的操作类
     * 
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andUriIsNull() {
            addCriterion("uri is null");
            return (Criteria) this;
        }

        public Criteria andUriIsNotNull() {
            addCriterion("uri is not null");
            return (Criteria) this;
        }

        public Criteria andUriEqualTo(String value) {
            addCriterion("uri =", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotEqualTo(String value) {
            addCriterion("uri <>", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThan(String value) {
            addCriterion("uri >", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThanOrEqualTo(String value) {
            addCriterion("uri >=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThan(String value) {
            addCriterion("uri <", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThanOrEqualTo(String value) {
            addCriterion("uri <=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLike(String value) {
            addCriterion("uri like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotLike(String value) {
            addCriterion("uri not like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriIn(List<String> values) {
            addCriterion("uri in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotIn(List<String> values) {
            addCriterion("uri not in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriBetween(String value1, String value2) {
            addCriterion("uri between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotBetween(String value1, String value2) {
            addCriterion("uri not between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationIsNull() {
            addCriterion("access_count_duration is null");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationIsNotNull() {
            addCriterion("access_count_duration is not null");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationEqualTo(Long value) {
            addCriterion("access_count_duration =", value, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationNotEqualTo(Long value) {
            addCriterion("access_count_duration <>", value, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationGreaterThan(Long value) {
            addCriterion("access_count_duration >", value, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("access_count_duration >=", value, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationLessThan(Long value) {
            addCriterion("access_count_duration <", value, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationLessThanOrEqualTo(Long value) {
            addCriterion("access_count_duration <=", value, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationIn(List<Long> values) {
            addCriterion("access_count_duration in", values, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationNotIn(List<Long> values) {
            addCriterion("access_count_duration not in", values, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationBetween(Long value1, Long value2) {
            addCriterion("access_count_duration between", value1, value2, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountDurationNotBetween(Long value1, Long value2) {
            addCriterion("access_count_duration not between", value1, value2, "accessCountDuration");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxIsNull() {
            addCriterion("access_count_max is null");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxIsNotNull() {
            addCriterion("access_count_max is not null");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxEqualTo(Integer value) {
            addCriterion("access_count_max =", value, "accessCountMax");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxNotEqualTo(Integer value) {
            addCriterion("access_count_max <>", value, "accessCountMax");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxGreaterThan(Integer value) {
            addCriterion("access_count_max >", value, "accessCountMax");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("access_count_max >=", value, "accessCountMax");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxLessThan(Integer value) {
            addCriterion("access_count_max <", value, "accessCountMax");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxLessThanOrEqualTo(Integer value) {
            addCriterion("access_count_max <=", value, "accessCountMax");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxIn(List<Integer> values) {
            addCriterion("access_count_max in", values, "accessCountMax");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxNotIn(List<Integer> values) {
            addCriterion("access_count_max not in", values, "accessCountMax");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxBetween(Integer value1, Integer value2) {
            addCriterion("access_count_max between", value1, value2, "accessCountMax");
            return (Criteria) this;
        }

        public Criteria andAccessCountMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("access_count_max not between", value1, value2, "accessCountMax");
            return (Criteria) this;
        }
    }

    /**
     * access_ip_control_config表的操作类
     * 
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * access_ip_control_config表的操作类
     * 
     */
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