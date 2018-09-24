package com.sun.curd.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
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

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNull() {
            addCriterion("emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNotNull() {
            addCriterion("emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameEqualTo(String value) {
            addCriterion("emp_name =", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThan(String value) {
            addCriterion("emp_name >", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThan(String value) {
            addCriterion("emp_name <", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLike(String value) {
            addCriterion("emp_name like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotLike(String value) {
            addCriterion("emp_name not like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIn(List<String> values) {
            addCriterion("emp_name in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotIn(List<String> values) {
            addCriterion("emp_name not in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameBetween(String value1, String value2) {
            addCriterion("emp_name between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNull() {
            addCriterion("emp_sex is null");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNotNull() {
            addCriterion("emp_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSexEqualTo(Integer value) {
            addCriterion("emp_sex =", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotEqualTo(Integer value) {
            addCriterion("emp_sex <>", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThan(Integer value) {
            addCriterion("emp_sex >", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_sex >=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThan(Integer value) {
            addCriterion("emp_sex <", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThanOrEqualTo(Integer value) {
            addCriterion("emp_sex <=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexIn(List<Integer> values) {
            addCriterion("emp_sex in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotIn(List<Integer> values) {
            addCriterion("emp_sex not in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexBetween(Integer value1, Integer value2) {
            addCriterion("emp_sex between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_sex not between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("dept_name is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("dept_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("dept_name =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("dept_name <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("dept_name >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_name >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("dept_name <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("dept_name <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("dept_name like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("dept_name not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("dept_name in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("dept_name not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("dept_name between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("dept_name not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andEmpCardIsNull() {
            addCriterion("emp_card is null");
            return (Criteria) this;
        }

        public Criteria andEmpCardIsNotNull() {
            addCriterion("emp_card is not null");
            return (Criteria) this;
        }

        public Criteria andEmpCardEqualTo(String value) {
            addCriterion("emp_card =", value, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardNotEqualTo(String value) {
            addCriterion("emp_card <>", value, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardGreaterThan(String value) {
            addCriterion("emp_card >", value, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardGreaterThanOrEqualTo(String value) {
            addCriterion("emp_card >=", value, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardLessThan(String value) {
            addCriterion("emp_card <", value, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardLessThanOrEqualTo(String value) {
            addCriterion("emp_card <=", value, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardLike(String value) {
            addCriterion("emp_card like", value, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardNotLike(String value) {
            addCriterion("emp_card not like", value, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardIn(List<String> values) {
            addCriterion("emp_card in", values, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardNotIn(List<String> values) {
            addCriterion("emp_card not in", values, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardBetween(String value1, String value2) {
            addCriterion("emp_card between", value1, value2, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpCardNotBetween(String value1, String value2) {
            addCriterion("emp_card not between", value1, value2, "empCard");
            return (Criteria) this;
        }

        public Criteria andEmpJobIsNull() {
            addCriterion("emp_job is null");
            return (Criteria) this;
        }

        public Criteria andEmpJobIsNotNull() {
            addCriterion("emp_job is not null");
            return (Criteria) this;
        }

        public Criteria andEmpJobEqualTo(String value) {
            addCriterion("emp_job =", value, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobNotEqualTo(String value) {
            addCriterion("emp_job <>", value, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobGreaterThan(String value) {
            addCriterion("emp_job >", value, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobGreaterThanOrEqualTo(String value) {
            addCriterion("emp_job >=", value, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobLessThan(String value) {
            addCriterion("emp_job <", value, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobLessThanOrEqualTo(String value) {
            addCriterion("emp_job <=", value, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobLike(String value) {
            addCriterion("emp_job like", value, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobNotLike(String value) {
            addCriterion("emp_job not like", value, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobIn(List<String> values) {
            addCriterion("emp_job in", values, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobNotIn(List<String> values) {
            addCriterion("emp_job not in", values, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobBetween(String value1, String value2) {
            addCriterion("emp_job between", value1, value2, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpJobNotBetween(String value1, String value2) {
            addCriterion("emp_job not between", value1, value2, "empJob");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNull() {
            addCriterion("emp_address is null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNotNull() {
            addCriterion("emp_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressEqualTo(String value) {
            addCriterion("emp_address =", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotEqualTo(String value) {
            addCriterion("emp_address <>", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThan(String value) {
            addCriterion("emp_address >", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("emp_address >=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThan(String value) {
            addCriterion("emp_address <", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThanOrEqualTo(String value) {
            addCriterion("emp_address <=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLike(String value) {
            addCriterion("emp_address like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotLike(String value) {
            addCriterion("emp_address not like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIn(List<String> values) {
            addCriterion("emp_address in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotIn(List<String> values) {
            addCriterion("emp_address not in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressBetween(String value1, String value2) {
            addCriterion("emp_address between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotBetween(String value1, String value2) {
            addCriterion("emp_address not between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberIsNull() {
            addCriterion("emp_telnumber is null");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberIsNotNull() {
            addCriterion("emp_telnumber is not null");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberEqualTo(String value) {
            addCriterion("emp_telnumber =", value, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberNotEqualTo(String value) {
            addCriterion("emp_telnumber <>", value, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberGreaterThan(String value) {
            addCriterion("emp_telnumber >", value, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberGreaterThanOrEqualTo(String value) {
            addCriterion("emp_telnumber >=", value, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberLessThan(String value) {
            addCriterion("emp_telnumber <", value, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberLessThanOrEqualTo(String value) {
            addCriterion("emp_telnumber <=", value, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberLike(String value) {
            addCriterion("emp_telnumber like", value, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberNotLike(String value) {
            addCriterion("emp_telnumber not like", value, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberIn(List<String> values) {
            addCriterion("emp_telnumber in", values, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberNotIn(List<String> values) {
            addCriterion("emp_telnumber not in", values, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberBetween(String value1, String value2) {
            addCriterion("emp_telnumber between", value1, value2, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpTelnumberNotBetween(String value1, String value2) {
            addCriterion("emp_telnumber not between", value1, value2, "empTelnumber");
            return (Criteria) this;
        }

        public Criteria andEmpDateIsNull() {
            addCriterion("emp_date is null");
            return (Criteria) this;
        }

        public Criteria andEmpDateIsNotNull() {
            addCriterion("emp_date is not null");
            return (Criteria) this;
        }

        public Criteria andEmpDateEqualTo(String value) {
            addCriterion("emp_date =", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateNotEqualTo(String value) {
            addCriterion("emp_date <>", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateGreaterThan(String value) {
            addCriterion("emp_date >", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateGreaterThanOrEqualTo(String value) {
            addCriterion("emp_date >=", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateLessThan(String value) {
            addCriterion("emp_date <", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateLessThanOrEqualTo(String value) {
            addCriterion("emp_date <=", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateLike(String value) {
            addCriterion("emp_date like", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateNotLike(String value) {
            addCriterion("emp_date not like", value, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateIn(List<String> values) {
            addCriterion("emp_date in", values, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateNotIn(List<String> values) {
            addCriterion("emp_date not in", values, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateBetween(String value1, String value2) {
            addCriterion("emp_date between", value1, value2, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpDateNotBetween(String value1, String value2) {
            addCriterion("emp_date not between", value1, value2, "empDate");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyIsNull() {
            addCriterion("emp_money is null");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyIsNotNull() {
            addCriterion("emp_money is not null");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyEqualTo(Integer value) {
            addCriterion("emp_money =", value, "empMoney");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyNotEqualTo(Integer value) {
            addCriterion("emp_money <>", value, "empMoney");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyGreaterThan(Integer value) {
            addCriterion("emp_money >", value, "empMoney");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_money >=", value, "empMoney");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyLessThan(Integer value) {
            addCriterion("emp_money <", value, "empMoney");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("emp_money <=", value, "empMoney");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyIn(List<Integer> values) {
            addCriterion("emp_money in", values, "empMoney");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyNotIn(List<Integer> values) {
            addCriterion("emp_money not in", values, "empMoney");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyBetween(Integer value1, Integer value2) {
            addCriterion("emp_money between", value1, value2, "empMoney");
            return (Criteria) this;
        }

        public Criteria andEmpMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_money not between", value1, value2, "empMoney");
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