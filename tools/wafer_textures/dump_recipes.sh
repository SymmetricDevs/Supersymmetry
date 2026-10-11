#!/usr/bin/env bash
# Runs the pack's semiconductor recipe scripts against stubbed GregTech/GroovyScript APIs and dumps
# every recipe they register (plus the helper call that produced it) to JSON for generate.py.
#
# Usage: tools/wafer_textures/dump_recipes.sh [out.json]
# Needs java and a Groovy 4 jar (records are used in the helpers); set GROOVY_JAR / GROOVY_JSON_JAR
# to override the lookup in the Gradle distribution cache.
set -euo pipefail

HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO="$(cd "$HERE/../.." && pwd)"
OUT="${1:-$HERE/build/recipes.json}"
BUILD="$HERE/build"

find_jar() {
    find "$HOME/.gradle" -name "$1" 2>/dev/null | sort -V | tail -1
}
GROOVY_JAR="${GROOVY_JAR:-$(find_jar 'groovy-4.*.jar')}"
GROOVY_JSON_JAR="${GROOVY_JSON_JAR:-$(find_jar 'groovy-json-4.*.jar')}"
if [[ -z "$GROOVY_JAR" || -z "$GROOVY_JSON_JAR" ]]; then
    echo "Could not find Groovy 4 jars; set GROOVY_JAR and GROOVY_JSON_JAR" >&2
    exit 1
fi
CP="$GROOVY_JAR:$GROOVY_JSON_JAR"

rm -rf "$BUILD/src" "$BUILD/classes"
mkdir -p "$BUILD/src/globals/semiconductors" "$BUILD/src/prePostInit" "$BUILD/classes"
cp -r "$HERE/harness/src/." "$BUILD/src/"
cp "$REPO/groovy/prePostInit/Recipemaps.groovy" "$BUILD/src/prePostInit/"
cp "$REPO"/groovy/globals/semiconductors/*.groovy "$BUILD/src/globals/semiconductors/"
# Route metaitem()/fluid()/recipemap()/log through the recording stubs
for f in "$BUILD/src/prePostInit/Recipemaps.groovy" "$BUILD"/src/globals/semiconductors/*.groovy; do
    sed -i '0,/^package .*/s//&\nimport static Stubs.*/' "$f"
    sed -i '/^import globals.Globals/d' "$f"
done

java -cp "$CP" org.codehaus.groovy.tools.FileSystemCompiler -d "$BUILD/classes" $(find "$BUILD/src" -name '*.groovy')

SCRIPTS=(
    components/electronics/Wafers.groovy
    components/electronics/SolarPanels.groovy
    components/electronics/ElectronicCeramics.groovy
    components/electronics/circuits/EarlyIntegratedCircuits.groovy
    components/electronics/circuits/IntermediateIntegratedCircuits.groovy
    components/electronics/circuits/PowerRegulationCircuits.groovy
    components/electronics/discrete_devices/Diodes.groovy
    components/electronics/discrete_devices/DiscreteDevices.groovy
    components/electronics/discrete_devices/Resistors.groovy
    components/electronics/discrete_devices/SMTComponents.groovy
    components/electronics/discrete_devices/Transistors.groovy
    components/electronics/discrete_devices/Capacitors.groovy
    chemistry/electronic_chemicals/EtchablesChain.groovy
    chemistry/inorganic_chemistry/GemChain.groovy
)
mkdir -p "$(dirname "$OUT")"
java -cp "$CP:$BUILD/classes" groovy.ui.GroovyMain "$HERE/harness/Run.groovy" "$REPO/groovy/postInit" "${SCRIPTS[@]}" "$OUT"
