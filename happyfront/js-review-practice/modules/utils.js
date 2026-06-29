export const PI = 3.14159;

export function add(a, b) {
  return a + b;
}

export function subtract(a, b) {
  return a - b;
}

// 또는 한 번에 내보내기
const multiply = (a, b) => a * b;
const divide = (a, b) => a / b;

export { multiply, divide };
