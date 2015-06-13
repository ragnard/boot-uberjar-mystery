let
  pkgs = import <nixpkgs> {};
  stdenv = pkgs.stdenv;
  jdk = pkgs.oraclejdk8;
in stdenv.mkDerivation rec {
  name = "boot-uberjar-mystery";
  version = "1.0";
  buildInputs = [
    jdk
    (pkgs.leiningen.override {
      jdk = jdk;
    })
    (pkgs.boot.override {
      jdk = jdk;
    })
  ];
}

