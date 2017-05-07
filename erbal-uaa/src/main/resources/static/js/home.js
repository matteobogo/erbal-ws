$.get( "/erbal-uaa/current", function( data ) {
    $( "body" )
        .append( "Email: " + data.principal.username )
        .append( "<br/>" )
        .append( "Nome: " + data.principal.firstname )
        .append( "Cognome: " + data.principal.lastname )
        .append( "Nome Serra: " + data.principal.greenhouseName);
}, "json" );