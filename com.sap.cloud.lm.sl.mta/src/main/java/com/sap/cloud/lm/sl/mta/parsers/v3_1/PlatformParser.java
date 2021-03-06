package com.sap.cloud.lm.sl.mta.parsers.v3_1;

import static com.sap.cloud.lm.sl.mta.handlers.v3_1.Schemas.PLATFORM_TYPE;

import java.util.List;
import java.util.Map;

import com.sap.cloud.lm.sl.common.ParsingException;
import com.sap.cloud.lm.sl.common.util.ListUtil;
import com.sap.cloud.lm.sl.mta.model.v3_1.ModuleType;
import com.sap.cloud.lm.sl.mta.model.v3_1.Platform;
import com.sap.cloud.lm.sl.mta.model.v3_1.Platform.PlatformBuilder;
import com.sap.cloud.lm.sl.mta.model.v3_1.ResourceType;
import com.sap.cloud.lm.sl.mta.schema.MapElement;

public class PlatformParser extends com.sap.cloud.lm.sl.mta.parsers.v3_0.PlatformParser {

    public PlatformParser(Map<String, Object> source) {
        super(PLATFORM_TYPE, source);
    }

    protected PlatformParser(MapElement schema, Map<String, Object> source) {
        super(schema, source);
    }

    @Override
    public Platform parse() throws ParsingException {
        PlatformBuilder builder = new PlatformBuilder();
        builder.setName(getName());
        builder.setDescription(getDescription());
        builder.setParameters(getParameters());
        builder.setModuleTypes3_1(getModuleTypes3_1());
        builder.setResourceTypes3_1(getResourceTypes3_1());
        return builder.build();
    }

    protected List<ModuleType> getModuleTypes3_1() throws ParsingException {
        return ListUtil.cast(getModuleTypes3_0());
    }

    @Override
    protected ModuleTypeParser getModuleTypeParser(Map<String, Object> source) {
        return new ModuleTypeParser(source);
    }

    protected List<ResourceType> getResourceTypes3_1() throws ParsingException {
        return ListUtil.cast(getResourceTypes3_0());
    }

    @Override
    protected ResourceTypeParser getResourceTypeParser(Map<String, Object> source) {
        return new ResourceTypeParser(source);
    }

}
