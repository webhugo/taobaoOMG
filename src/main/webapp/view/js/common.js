/**
 * Created by webhugo on 17-7-6.
 */

//     Mini Cart
paypal.minicart.render({
    action: '#'
});

if (~window.location.search.indexOf('reset=true')) {
    paypal.minicart.reset();
}
