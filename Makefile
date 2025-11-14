.PHONY: format build publishToLocal
format:
	./gradlew --parallel ktlintFormat
build:
	./gradlew --parallel clean build test
publishToLocal:
	./gradlew :library-testing:some-sdk:publishToMavenLocal
	./gradlew :library-testing:some-implementer:publishToMavenLocal