package optionaltask.test;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class House {
	private Optional<Person> owner = Optional.empty();
	private Optional<String> address = Optional.empty();
}
