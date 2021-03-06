/*
 * Fortify Plugin for SonarQube
 * Copyright (C) 2014 Vivien HENRIET and SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.fortify.base.metrics;

import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;
import org.sonar.api.measures.SumChildValuesFormula;

import java.util.Arrays;
import java.util.List;

public final class FortifyMetrics implements Metrics {

  public static final String DOMAIN = "Fortify";

  public static final String SECURITY_RATING_KEY = "fortify-security-rating";
  public static final Metric<Integer> SECURITY_RATING = new Metric.Builder(FortifyMetrics.SECURITY_RATING_KEY, "Fortify Security Rating", Metric.ValueType.INT)
    .setDescription("Fortify Security Rating")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(true)
    .setDomain(FortifyMetrics.DOMAIN)
    .setBestValue(5.0)
    .setFormula(new SecurityRatingFormula())
    .create();

  /**
   * The following metrics are used for the chart Impact versus Likelihood
   */
  public static final Metric<Integer> CFPO = new Metric.Builder("fortify-cfpo", "Fortify Critical Severity Issues", Metric.ValueType.INT)
    .setDescription("Fortify Critical Priority Issues")
    .setDirection(Metric.DIRECTION_WORST)
    .setQualitative(false)
    .setDomain(FortifyMetrics.DOMAIN)
    .setBestValue(0.0)
    .setHidden(true)
    .setFormula(new SumChildValuesFormula(false))
    .create();

  public static final Metric<Integer> HFPO = new Metric.Builder("fortify-hfpo", "Fortify High Severity Issues", Metric.ValueType.INT)
    .setDescription("Fortify High Priority Issues")
    .setDirection(Metric.DIRECTION_WORST)
    .setQualitative(false)
    .setDomain(FortifyMetrics.DOMAIN)
    .setBestValue(0.0)
    .setHidden(true)
    .setFormula(new SumChildValuesFormula(false))
    .create();

  public static final Metric<Integer> MFPO = new Metric.Builder("fortify-mfpo", "Fortify Medium Severity Issues", Metric.ValueType.INT)
    .setDescription("Fortify Medium Priority Issues")
    .setDirection(Metric.DIRECTION_WORST)
    .setQualitative(false)
    .setDomain(FortifyMetrics.DOMAIN)
    .setBestValue(0.0)
    .setHidden(true)
    .setFormula(new SumChildValuesFormula(false))
    .create();

  public static final Metric<Integer> LFPO = new Metric.Builder("fortify-lfpo", "Fortify Low Severity Issues", Metric.ValueType.INT)
    .setDescription("Fortify Low Priority Issues")
    .setDirection(Metric.DIRECTION_WORST)
    .setQualitative(false)
    .setDomain(FortifyMetrics.DOMAIN)
    .setBestValue(0.0)
    .setHidden(true)
    .setFormula(new SumChildValuesFormula(false))
    .create();

  @Override
  public List<Metric> getMetrics() {
    return Arrays.<Metric>asList(FortifyMetrics.SECURITY_RATING, FortifyMetrics.CFPO, FortifyMetrics.HFPO, FortifyMetrics.MFPO, FortifyMetrics.LFPO);
  }
}
