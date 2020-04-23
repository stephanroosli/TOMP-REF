package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import io.swagger.model.AssetClass;
import io.swagger.model.Condition;
import io.swagger.model.Coordinate;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.OptionsLeg;
import io.swagger.model.PlanningCheck;
import io.swagger.model.PlanningOptions;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;
import io.swagger.model.TypeOfAsset;
import io.swagger.model.TypeOfAsset.EnergyLabelEnum;

@Component
@Profile("taxi")
public class TaxiPlanningProvider extends BasePlanningProvider {

	@Override
	protected Fare getFare() {
		Fare fare = new Fare();
		FarePart part = new FarePart();
		part.setType(TypeEnum.FIXED);
		part.setCurrencyCode("CHF");
		part.setAmount(BigDecimal.valueOf(6.50));
		part.setVatRate(BigDecimal.valueOf(7.7));
		fare.addPartsItem(part);
		return fare;
	}

	@Override
	protected OptionsLeg getLeg() {
		OptionsLeg leg = new OptionsLeg();
		leg.setFrom(from);
		leg.setTo(to);
		leg.setStartTime(start);
		leg.setEndTime(end);
		return leg;
	}

	@Override
	protected TypeOfAsset getAssetType() {
		TypeOfAsset typeOfAsset = new TypeOfAsset();
		typeOfAsset.setAssetClass(AssetClass.TAXI);
		typeOfAsset.setModel("Mercedes");
		return typeOfAsset;
	}

	@Override
	protected ArrayList<Condition> getConditions() {
		return new ArrayList<>();
	}
}
