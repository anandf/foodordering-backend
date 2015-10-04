<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Orders">
<h2>${pageTitle}</h2>
<ul class="orders">
    <#if orders??>
        <#list orders as order>
        <li>
            <p>${order.orderStartDate}</p>
            <p>${order.orderEndDate}</p>
            <p>${order.orderPlacedDate}</p>
            <p>${order.cuisineId}</p>
        <#else>
        <li><em>There're no messages so far.</em>
        </#list>
    <#else>
    <li><em>There're no messages so far.</em>
    </#if>
</ul>
</@layout.masterTemplate>