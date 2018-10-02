package com.qiaosoftware.sssp.utils;

import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.qiaosoftware.sssp.utils.Collections3;
import com.google.common.collect.Lists;

public class DynamicSpecifications {
	
	public static <T> Specification<T> byPropertyFilter(final Collection<PropertyFilter> filters) {
		
		return new Specification<T>() {
		
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				
				if (Collections3.isNotEmpty(filters)) {
					List<Predicate> predicates = Lists.newArrayList();
					
					for (PropertyFilter filter : filters) {
						
						String[] names = StringUtils.split(filter.getPropertyName(), ".");
						Path expression = root.get(names[0]);
						
						for (int i = 1; i < names.length; i++) {
							expression = expression.get(names[i]);
						}

						switch (filter.getMatchType()) {
						case EQ:
							predicates.add(builder.equal(expression, filter.getPropertyVal()));
							break;
						case NOTEQ:
							predicates.add(builder.notEqual(expression, filter.getPropertyVal()));
							break;
						case LIKE:
							predicates.add(builder.like(expression, "" + filter.getPropertyVal()));
							break;
						case GT:
							predicates.add(builder.greaterThan(expression, (Comparable) filter.getPropertyVal()));
							break;
						case LT:
							predicates.add(builder.lessThan(expression, (Comparable) filter.getPropertyVal()));
							break;
						case GTE:
							predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) filter.getPropertyVal()));
							break;
						case LTE:
							predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) filter.getPropertyVal()));
							break;
						case NULL:
							predicates.add(builder.isNull(expression));
							break;
						}
					}

					// 将所有条件用 and 联合起来
					if (predicates.size() > 0) {
						return builder.and(predicates.toArray(new Predicate[predicates.size()]));
					}
				}
				
				return builder.conjunction();
			}
		};
		
	}
}
