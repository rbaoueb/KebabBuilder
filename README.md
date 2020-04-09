
KebabBuilder is a JAVA API which allows us create / validate Kebabs according to some ingredients


## Installation
you can import the source project on your IDE or build the jar and push it to your maven repository :

```bash
git clone https://github.com/rbaoueb/KebabBuilder.git
cd KebabBuilder
mvn clean install
```

then add the generated dependency to your project pom.xml:
```xml
<dependencies>
    <dependency>
      <groupId>com.mrbaoueb</groupId>
	  <artifactId>KebabBuilder</artifactId>
      <version>1.0.0</version>
    </dependency>
</dependencies>
```

## Usage

There is an example of API usage (creating new Kebab and check-in/check-out a car) : 
```java

	public static void main(String[] args) {

		 Kebab kebab = Kebab.builder().ingredients(new LinkedList<>()).name("Kebab for test").build()
				.addIngredient(Ingredient.LAITUE)
				.addIngredient(Ingredient.CHEDDAR)
				.addIngredient(Ingredient.AGNEAU)
				.removeIngredient(Ingredient.AGNEAU)
				.doubleIngredient(KebabType.FROMAGE);

	}
	
```
