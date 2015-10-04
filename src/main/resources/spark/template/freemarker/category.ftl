<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Categories">
<h2>${pageTitle}</h2>
<ul class="categories">
    <#if categories??>
        <#list categories as category>
        <li>
            <p>${category.id}</p>
            <p>${category.name}</p>
            <p>${category.description}</p>
        <#else>
        <li><em>There're no messages so far.</em>
        </#list>
    <#else>
    <li><em>There're no messages so far.</em>
    </#if>
</ul>
</@layout.masterTemplate>