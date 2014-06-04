'use strict';

johnGShultzApp.controller('Fun_houseController', ['$scope', 'resolvedFun_house', 'Fun_house',
    function ($scope, resolvedFun_house, Fun_house) {

        $scope.fun_houses = resolvedFun_house;
        $scope.gallery = [
        { path: "../images/audrey.jpg", pathMod: "../images/audreyMod.jpg" },
        { path: "../images/average.bmp", pathMod: "../images/average.bmp" },
        { path: "../images/bieber_small.jpg", pathMod: "../images/bieber_smallMod.jpg" },
        { path: "../images/cage.jpg", pathMod: "../images/cageMod.jpg" },
        { path: "../images/ironman.jpg", pathMod: "../images/ironmanMod.jpg" },
        { path: "../images/jinx.jpg", pathMod: "../images/jinxMod.jpg" },
        { path: "../images/joconde.jpg", pathMod: "../images/jocondeMod.jpg" },
        { path: "../images/SeanConnery.jpg", pathMod: "../images/SeanConneryMod.jpg" },
        { path: "../images/skullmask.jpg", pathMod: "../images/skullmaskMod.jpg" },
        { path: "../images/vendetta.jpg", pathMod: "../images/vendetta.jpg" }
        ];
        $scope.mod_gallery = [
        { pathMod: "../images/audreyMod.jpg" },
        { pathMod: "../images/averageMod.bmp" },
        { pathMod: "../images/bieber_smallMod.jpg" },
        { pathMod: "../images/cageMod.jpg" },
        { pathMod: "../images/ironmanMod.jpg" },
        { pathMod: "../images/jinxMod.jpg" },
        { pathMod: "../images/jocondeMod.jpg" },
        { pathMod: "../images/SeanConneryMod.jpg" },
        { pathMod: "../images/skullmaskMod.jpg" },
        { pathMod: "../images/vendettaMod.jpg" }
        ];
        for (var i = 0; i < $scope.gallery.length; i++) {
          $scope.gallery[i].d = randomN(true)+"deg";
          $scope.gallery[i].x = randomN(false);
          $scope.gallery[i].y = randomN(false);
          $scope.gallery[i].desktopStyle="animation-duration: "+i+"s; \
          left:"+$scope.gallery[i].x+"px; \
          top:"+$scope.gallery[i].y+"px; \
          -ms-transform: rotate("+$scope.gallery[i].d+"); \
          -webkit-transform: rotate("+$scope.gallery[i].d+"); \
          transform: rotate("+$scope.gallery[i].d+");";
        }
        setTimeout(function(){
          $( ".photo " ).draggable({
            start: function() {
              $(".photo").click();
            },
            drag: function() {
              $(".photo").click();
            },
            stop: function() {
              $(".photo").click();
            }
          });
          $(".photo").click(function(){
            $(".photo").removeClass("active");
            $(this).addClass("active");
          });

        }, 1000);

        function randomN(negValues) {
          var n = Math.floor((Math.random() * 100) + 1);
          if (n > 50 && negValues) {
            n = n * -1;
          }
          n = (n / 3);
          return n;
        }
    }]);
