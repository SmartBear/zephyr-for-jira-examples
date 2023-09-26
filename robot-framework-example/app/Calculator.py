class Calculator(object):

    def __init__(self):
        self.clear()

    def clear(self):
        self._number1 = 0
        self._number2 = 0
        self._result = None
        self._display = 0
        self._operator = None

    def input_number(self, number):
        if self._operator is None:
            self._number1 = number
        else:
            self._number2 = number

    def press_operator(self, operator):
        self._operator = operator

    def calculate(self):
        self._result = eval(self._number1 + self._operator + self._number2) 

    def display_should_be_empty(self):
        self._display == 0

    def result_should_be(self, expected_result):
        if int(expected_result) != self._result:
            raise AssertionError("Expected result to be '%s' but was '%s'."
                                 % (expected_result, self._result))

    