${event.name}.cpp
/* Autogenerated with kurento-module-creator */

#include "${event.name}.hpp"
#include <jsonrpc/JsonSerializer.hpp>
<#list event.properties as property>
<#if model.remoteClasses?seq_contains(property.type.type) ||
  model.complexTypes?seq_contains(property.type.type) ||
  model.events?seq_contains(property.type.type)>
#include "${property.type.name}.hpp"
</#if>
</#list>

namespace kurento
{

void
${event.name}::Serialize (JsonSerializer &s)
{
<#if event.extends??>
  ${event.extends.name}::Serialize (s);

</#if>
<#list event.properties as property>
  s.SerializeNVP (${property.name});
</#list>
}

void Serialize (std::shared_ptr<${event.name}> &event, JsonSerializer &s)
{
  if (!s.IsWriter && !event) {
    event.reset (new kurento::${event.name}() );
  }

  if (event) {
    event->Serialize (s);
  }
}

} /* kurento */
