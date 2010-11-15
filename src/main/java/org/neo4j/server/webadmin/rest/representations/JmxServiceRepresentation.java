/**
 * Copyright (c) 2002-2010 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.neo4j.server.webadmin.rest.representations;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.neo4j.server.rest.domain.Representation;
import org.neo4j.server.webadmin.rest.JmxService;

public class JmxServiceRepresentation implements Representation
{
    private String baseUri;

    public JmxServiceRepresentation( URI baseUri )
    {
        this.baseUri = baseUri + JmxService.ROOT_PATH;
    }

    public Object serialize()
    {
        Map<String, Object> def = new HashMap<String, Object>();
        Map<String, Object> resources = new HashMap<String, Object>();

        resources.put( "domains", baseUri + JmxService.DOMAINS_PATH );
        resources.put( "domain", baseUri + JmxService.DOMAIN_PATH );
        resources.put( "bean", baseUri + JmxService.BEAN_PATH );
        resources.put( "query", baseUri + JmxService.QUERY_PATH );
        resources.put( "kernelquery", baseUri + JmxService.KERNEL_NAME_PATH );

        def.put( "resources", resources );
        return def;
    }
}
