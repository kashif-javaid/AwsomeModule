import * as React from 'react';

import { StyleSheet, View, Text, Platform } from 'react-native';
import AwesomeModule, {
  ReactNativeStripeCardInput,
  ReactNativeStripeCardInputText,
} from 'react-native-awesome-module';

export default function App() {
  const [result, setResult] = React.useState<number | undefined>();

  React.useEffect(() => {
    AwesomeModule.multiply(3, 7).then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
      <ReactNativeStripeCardInputText
        text="Hello World"
        onTouch={() => console.log('TOUCHED ReactNativeStripeCardInputText')}
        style={{
          backgroundColor: 'transparent',
          width: 300,
          height: 50,
          fontSize: 25,
        }}
      />
      <ReactNativeStripeCardInput
        style={styles.cardInput}
        onInputChanged={() => console.log('✅ ReactNativeStripeCardInput')}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
  cardInput: {
    width: Platform.OS === 'ios' ? 300 : '100%',
    height: Platform.OS === 'ios' ? 50 : 200,
    marginTop: 26,
  },
});
